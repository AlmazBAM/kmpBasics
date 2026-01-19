package com.bagmanov.helloworldkmp.data.networking

import kotlinx.serialization.Serializable

@Serializable
data class CensoredTextDto(
    val result: String
)
