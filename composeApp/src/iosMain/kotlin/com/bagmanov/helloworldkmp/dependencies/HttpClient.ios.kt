package com.bagmanov.helloworldkmp.dependencies

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual fun provideHttpClientEngine(): HttpClientEngine {
    return Darwin.create()
}