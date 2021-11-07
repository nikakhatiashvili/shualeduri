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
import kotlinx.coroutines.flow.map

private val Context._dataStore: DataStore<Preferences> by preferencesDataStore("User_Info")

class UserManager(context: Context?) {


    private val dataStore: DataStore<Preferences> = context!!._dataStore

    companion object {

        val USER_EMAIL_KEY = stringPreferencesKey("EMAIL")

    }


    //Store user data
    suspend fun storeUser(
        email: String,
    ) {
        dataStore.edit {
            it[USER_EMAIL_KEY] = email
        }
    }
    private fun isLogin(): String? {
        return  email.value
    }


    private fun getSession():String?{
        return  email.value
    }


    var email: LiveData<String> = dataStore.data.map {
        it[USER_EMAIL_KEY] ?: "null"
    }.asLiveData()



}