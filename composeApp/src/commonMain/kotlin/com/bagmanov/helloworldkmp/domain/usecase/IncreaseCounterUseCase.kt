package com.bagmanov.helloworldkmp.domain.usecase

import com.bagmanov.helloworldkmp.domain.repository.SettingsRepository

class IncreaseCounterUseCase(
    private val repository: SettingsRepository
) {
    suspend operator fun invoke(value: Int) = repository.increaseCounter(value)
}