package com.bagmanov.helloworldkmp.domain.usecase

import com.bagmanov.helloworldkmp.domain.repository.SettingsRepository

class ObserveCounterUseCase(
    private val repository: SettingsRepository
) {
    operator fun invoke() = repository.observeCounter()
}