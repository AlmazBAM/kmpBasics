package com.bagmanov.helloworldkmp.networking

import kotlinx.serialization.Serializable

@Serializable
data class CensoredTextDto(
    val result: String
)
