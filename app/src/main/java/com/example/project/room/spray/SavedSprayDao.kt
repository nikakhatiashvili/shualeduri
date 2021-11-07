package com.example.project.room.spray

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.project.model.User
import com.example.project.model.saved.SavedSprays


@Dao
interface SavedSprayDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSpray(user: SavedSprays)


    @Query("SELECT * FROM favorites")
    fun readAllData(): LiveData<List<SavedSprays>>

    @Query("DELETE FROM favorites")
    suspend fun deleteAll()

}

