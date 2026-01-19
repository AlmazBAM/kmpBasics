package com.bagmanov.helloworldkmp.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.map

class SettingsDataStoreImpl(
    private val dataStore: DataStore<Preferences>
) : SettingsDataStore {

    override val counter = dataStore.data.map {
        it[COUNTER] ?: 0
    }

    override suspend fun setCounter(value: Int) {
        dataStore.edit { it[COUNTER] = value }
    }

    companion object {
        private val COUNTER = intPreferencesKey("counter")
    }
}