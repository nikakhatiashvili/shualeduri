package com.example.project.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.model.weapons.WeaponsData
import com.example.project.network.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SlideshowViewModel:ViewModel() {

//    private var _characters = MutableLiveData<List<Agents>>()
//    val characters: LiveData<List<Agents>> get() = _characters
    private var _agentInfo = MutableLiveData<List<WeaponsData>>()
    val agentInfo: LiveData<List<WeaponsData>> get() = _agentInfo


    fun load(){
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO){
                ApiService.agentService.getAllWeapons()
            }
            _agentInfo.postValue(data.body()?.data!!)
        }
    }

}