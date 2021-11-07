package com.example.project.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.project.model.User
import com.google.firebase.auth.UserInfo
import kotlinx.coroutines.flow.map


private val Context._dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("User_Info")
class UserManager(private val context: Context) {
    private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences> = context!!._dataStore

    companion object {
        val EMAIL = stringPreferencesKey("EMAIL_KEY")
    }


    suspend fun saveToDataStore(userInfo: User) {
        dataStore.edit {
            it[EMAIL] = userInfo.email
        }
    }
    suspend fun getFromDataStore() = dataStore.data.map {
        User(
            email = it[EMAIL] ?: "",
        )
    }.asLiveData()
}