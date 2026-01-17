package com.bagmanov.helloworldkmp.di

import com.bagmanov.helloworldkmp.dependencies.MainViewModel
import com.bagmanov.helloworldkmp.dependencies.Repository
import com.bagmanov.helloworldkmp.dependencies.RepositoryImpl
import com.bagmanov.helloworldkmp.dependencies.provideHttpClientEngine
import com.bagmanov.helloworldkmp.networking.InsultCensorWord
import com.bagmanov.helloworldkmp.networking.createHttpClient
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
}