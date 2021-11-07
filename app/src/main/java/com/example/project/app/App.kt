package com.example.project.app

import android.app.Application

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

//class App : Application() {
//    // No need to cancel this scope as it'll be torn down with the process
//    val applicationScope = CoroutineScope(SupervisorJob())
//
//    // Using by lazy so the database and the repository are only created when they're needed
//    // rather than when the application starts
//    val database = WordRoomDatabase.getDatabase(this, applicationScope)
//
//    val repository = FavoriteRepository(database.wordDao())
//}
