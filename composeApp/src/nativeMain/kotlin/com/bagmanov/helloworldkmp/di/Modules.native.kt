package com.bagmanov.helloworldkmp.di

import com.bagmanov.helloworldkmp.dependencies.DbClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModules = module {
    singleOf(::DbClient)
}