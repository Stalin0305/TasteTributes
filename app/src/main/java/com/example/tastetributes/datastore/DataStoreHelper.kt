package com.example.tastetributes.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject



const val PREFERENCE_NAME = "taste_tribute_preferences"

class DataStoreHelper @Inject constructor(
    private val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(PREFERENCE_NAME)

    companion object {
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    }

    suspend fun <T> saveToDataStore(keyName: Preferences.Key<T>, value: T) {
        context.dataStore.edit { preference ->
            preference[keyName] = value
        }
    }

    fun <T> readFromDataStore(keyName: Preferences.Key<T>) : Flow<T?> {
        return context.dataStore.data.map { preferences ->
            preferences[keyName]
        }
    }

}