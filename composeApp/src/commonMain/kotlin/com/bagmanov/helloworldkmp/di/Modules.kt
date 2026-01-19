package com.bagmanov.helloworldkmp.di

import com.bagmanov.helloworldkmp.data.datastore.SettingsDataStore
import com.bagmanov.helloworldkmp.data.datastore.SettingsDataStoreImpl
import com.bagmanov.helloworldkmp.data.datastore.createDataStore
import com.bagmanov.helloworldkmp.dependencies.MainViewModel
import com.bagmanov.helloworldkmp.dependencies.Repository
import com.bagmanov.helloworldkmp.dependencies.RepositoryImpl
import com.bagmanov.helloworldkmp.dependencies.provideHttpClientEngine
import com.bagmanov.helloworldkmp.data.networking.InsultCensorWord
import com.bagmanov.helloworldkmp.data.networking.createHttpClient
import com.bagmanov.helloworldkmp.data.repository.SettingsRepositoryImpl
import com.bagmanov.helloworldkmp.domain.repository.SettingsRepository
import com.bagmanov.helloworldkmp.domain.usecase.IncreaseCounterUseCase
import com.bagmanov.helloworldkmp.domain.usecase.ObserveCounterUseCase
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModules: Module

val sharedModules = module {
    singleOf(::RepositoryImpl).bind<Repository>()
    viewModelOf(::MainViewModel)

    single {
        createHttpClient(provideHttpClientEngine())
    }
    single {
        InsultCensorWord(get())
    }
    singleOf(::IncreaseCounterUseCase)
    singleOf(::ObserveCounterUseCase)

    singleOf(::SettingsDataStoreImpl).bind<SettingsDataStore>()
    singleOf(::SettingsRepositoryImpl).bind<SettingsRepository>()
}