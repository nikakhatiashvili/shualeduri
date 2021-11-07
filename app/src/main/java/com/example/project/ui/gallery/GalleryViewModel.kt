package com.example.project.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.model.agents.Agents
import com.example.project.model.agents.Data
import com.example.project.network.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GalleryViewModel:ViewModel() {

    private var _characters = MutableLiveData<List<Agents>>()
    val characters: LiveData<List<Agents>> get() = _characters
    private var _agentInfo = MutableLiveData<List<Data>>()
    val agentInfo: LiveData<List<Data>> get() = _agentInfo


    fun load(){
         viewModelScope.launch {
            val data = withContext(Dispatchers.IO){
                ApiService.agentService.getAllCharacters()
            }
            _agentInfo.postValue(data.body()?.data!!)
        }
    }
}