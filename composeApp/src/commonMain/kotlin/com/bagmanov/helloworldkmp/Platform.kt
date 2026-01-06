package com.bagmanov.helloworldkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform