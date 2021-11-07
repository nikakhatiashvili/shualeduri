package com.example.project.room.spray

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project.model.saved.SavedSprays

@Database(entities = [SavedSprays::class], version = 1, exportSchema = false)
abstract class FavoriteSprayData : RoomDatabase() {

    abstract fun userDao(): SavedSprayDao

    companion object {
        @Volatile
        private var INSTANCE: FavoriteSprayData? = null

        fun getDatabase(context: Context): FavoriteSprayData {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteSprayData::class.java,
                    "user_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}