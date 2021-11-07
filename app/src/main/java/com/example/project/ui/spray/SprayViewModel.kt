package com.example.project.ui.spray

import android.app.Application
import androidx.lifecycle.*
import com.example.project.model.saved.SavedSprays
import com.example.project.model.sprays.SpraysData
import com.example.project.network.api.ApiService
import com.example.project.room.spray.FavoriteRepository
import com.example.project.room.spray.FavoriteSprayData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SprayViewModel(application: Application):ViewModel() {

    private var _sprayInfo = MutableLiveData<List<SpraysData>>()
    val sprayInfo: LiveData<List<SpraysData>> get() = _sprayInfo



    fun load(){
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO){
                ApiService.agentService.getAllSprays()
            }
            _sprayInfo.postValue(data.body()?.data!!)
        }
    }
    val readAllData: LiveData<List<SavedSprays>>
    private val repository: FavoriteRepository

    init {
        val userDao = FavoriteSprayData.getDatabase(application).userDao()
        repository = FavoriteRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addSpray(user: SavedSprays) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSpray(user)
        }
    }

    fun delete(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete()
        }
    }

//    fun getMoviesFromDataBase(){
//        viewModelScope.launch {
//            val data = withContext(Dispatchers.IO){
//                DataInit.db.savedMoviesDao().getAll()
//            }
//            _savedMovies.postValue(data)
//            currentMovie.value?.let { checker(it) }
//        }
//    }
//    fun checker(sprays: SavedSprays){
//        _savedInfo.postValue(sprays)
//    }
//
//    fun addSpray(savedSpray:SavedSprays){
//        viewModelScope.launch {
//            withContext(Dispatchers.IO){
//                DataInit.db.savedSpray().insert(savedSpray)
//            }
//            checker(_savedInfo.value!!)
//        }
//    }
}
class WordViewModelFactory(private val application: Application ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SprayViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SprayViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
