package com.bagmanov.helloworldkmp.dependencies

import io.ktor.client.engine.HttpClientEngine

expect fun provideHttpClientEngine(): HttpClientEngine