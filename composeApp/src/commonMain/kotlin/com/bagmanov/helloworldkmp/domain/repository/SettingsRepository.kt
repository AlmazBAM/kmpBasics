package com.bagmanov.helloworldkmp.domain.repository

import com.bagmanov.helloworldkmp.domain.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun observeCounter(): Flow<Settings>
    suspend fun increaseCounter(value: Int)
}