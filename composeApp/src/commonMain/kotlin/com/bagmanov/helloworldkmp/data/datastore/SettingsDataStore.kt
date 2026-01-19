package com.bagmanov.helloworldkmp.data.datastore

import kotlinx.coroutines.flow.Flow

interface SettingsDataStore {
    val counter: Flow<Int>
    suspend fun setCounter(value: Int)
}