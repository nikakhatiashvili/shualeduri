package com.example.project.ui.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.model.maps.MapData
import com.example.project.network.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MapViewModel:ViewModel() {

    private var _agentInfo = MutableLiveData<List<MapData>>()
    val agentInfo: LiveData<List<MapData>> get() = _agentInfo


    fun load(){
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO){
                ApiService.agentService.getAllMaps()
            }
            _agentInfo.postValue(data.body()?.data!!)
        }
    }

}