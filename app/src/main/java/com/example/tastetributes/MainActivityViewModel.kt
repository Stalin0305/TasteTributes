package com.example.tastetributes

import androidx.lifecycle.ViewModel
import com.example.tastetributes.datastore.DataStoreHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val dataStoreHelper: DataStoreHelper,
) : ViewModel() {

    suspend fun isLoggedIn(): Boolean {
        return dataStoreHelper.readFromDataStore(DataStoreHelper.IS_LOGGED_IN).first() ?: false
    }

}