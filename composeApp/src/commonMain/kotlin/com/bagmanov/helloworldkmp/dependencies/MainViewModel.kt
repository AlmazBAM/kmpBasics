package com.bagmanov.helloworldkmp.dependencies

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagmanov.helloworldkmp.MainUiState
import com.bagmanov.helloworldkmp.networking.InsultCensorWord
import com.bagmanov.helloworldkmp.util.onError
import com.bagmanov.helloworldkmp.util.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository,
    private val makeCensorWord: InsultCensorWord
): ViewModel() {

    private var _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()
    fun getHelloWorldString() = repository.getHelloWorld()


    fun censorWords(uncensoredWords: String) {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(
                    isLoading = true
                )
            }
            makeCensorWord.censorWords(uncensoredWords)
                .onSuccess {  censorWord ->
                     _uiState.update { state ->
                         state.copy(
                             success = censorWord,
                             isLoading = false
                         )
                     }
                }.onError { networkError ->
                    _uiState.update { state ->
                        state.copy(
                            errorMessage = networkError.name,
                            isLoading = false
                        )
                    }
                }
        }
    }
}