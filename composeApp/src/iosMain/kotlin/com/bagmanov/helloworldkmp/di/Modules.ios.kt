package com.bagmanov.helloworldkmp.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.bagmanov.helloworldkmp.data.datastore.createDataStore
import com.bagmanov.helloworldkmp.dependencies.DbClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModules = module {
    singleOf(::DbClient)

    single<DataStore<Preferences>> {
        createDataStore()
    }
}