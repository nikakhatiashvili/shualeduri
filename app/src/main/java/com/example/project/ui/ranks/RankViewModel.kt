package com.example.project.ui.ranks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.model.ranks.Player
import com.example.project.network.api.ApiService


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RankViewModel: ViewModel() {

        //    private var _characters = MutableLiveData<List<Agents>>()
//    val characters: LiveData<List<Agents>> get() = _characters
        private var _rankInfo = MutableLiveData<List<Player>>()
        val rankInfo: LiveData<List<Player>> get() = _rankInfo


        fun load(){
                viewModelScope.launch {
                    val data = withContext(Dispatchers.IO){
                        ApiService.rankService.getAllRanks()
                    }
                    _rankInfo.postValue(data.body()?.players!!)
                }
            }
        }


