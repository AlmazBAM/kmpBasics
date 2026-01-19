package com.bagmanov.helloworldkmp.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class MainUiState(
    val isLoading: Boolean = false,
    val success: String = "",
    val errorMessage: String = ""
)