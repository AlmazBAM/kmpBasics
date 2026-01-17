package com.bagmanov.helloworldkmp.dependencies

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual fun provideHttpClientEngine(): HttpClientEngine {
    return OkHttp.create()
}