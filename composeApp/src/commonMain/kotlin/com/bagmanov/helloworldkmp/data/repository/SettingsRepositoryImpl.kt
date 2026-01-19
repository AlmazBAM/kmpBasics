package com.bagmanov.helloworldkmp.data.repository

import com.bagmanov.helloworldkmp.data.datastore.SettingsDataStore
import com.bagmanov.helloworldkmp.domain.model.Settings
import com.bagmanov.helloworldkmp.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.map

class SettingsRepositoryImpl(
    private val dataStore: SettingsDataStore
) : SettingsRepository {
    override fun observeCounter() =
        dataStore.counter.map { value ->
            Settings(
                counter = value
            )
        }

    override suspend fun increaseCounter(value: Int) {
        dataStore.setCounter(value)
    }
}
