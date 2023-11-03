package com.example.jetsynapsissubmission.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "setting_pref")

class SettingPref @Inject constructor(private val context: Context) {
    suspend fun putBoolean(key: String, value: Boolean){
        val prefKey = booleanPreferencesKey(key)
        context.datastore.edit {
            it[prefKey] = value
        }
    }

    suspend fun getBoolean(key: String): Boolean? {
        return try {
            val prefKey = booleanPreferencesKey(key)
            val preference = context.datastore.data.first()
            preference[prefKey]
        } catch (e: Exception){
           e.printStackTrace()
           null
        }
    }

    suspend fun clearPref(key: String){
        val prefKey = booleanPreferencesKey(key)
        context.datastore.edit {
            if (it.contains(prefKey)){
                it.remove(prefKey)
            }
        }
    }
}