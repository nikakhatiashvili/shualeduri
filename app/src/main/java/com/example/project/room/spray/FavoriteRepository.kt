package com.example.project.room.spray

import androidx.lifecycle.LiveData
import com.example.project.model.saved.SavedSprays

class FavoriteRepository(private val userDao: SavedSprayDao) {

    val readAllData: LiveData<List<SavedSprays>> = userDao.readAllData()



    suspend fun addSpray(user: SavedSprays){
        userDao.addSpray(user)
    }

    suspend fun delete(){
        userDao.deleteAll()
    }

}