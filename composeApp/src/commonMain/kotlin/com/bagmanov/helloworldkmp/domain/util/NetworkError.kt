package com.bagmanov.helloworldkmp.domain.util

enum class NetworkError: Error {

    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    UNAUTHORIZED,
    NO_INTERNET,
    CONNECTION_ERROR,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN,

}