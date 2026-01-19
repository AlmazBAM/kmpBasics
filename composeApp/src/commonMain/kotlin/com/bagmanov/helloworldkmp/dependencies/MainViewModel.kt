package com.bagmanov.helloworldkmp.dependencies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagmanov.helloworldkmp.presentation.MainUiState
import com.bagmanov.helloworldkmp.data.networking.InsultCensorWord
import com.bagmanov.helloworldkmp.domain.model.Settings
import com.bagmanov.helloworldkmp.domain.usecase.IncreaseCounterUseCase
import com.bagmanov.helloworldkmp.domain.usecase.ObserveCounterUseCase
import com.bagmanov.helloworldkmp.domain.util.onError
import com.bagmanov.helloworldkmp.domain.util.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository,
    private val makeCensorWord: InsultCensorWord,
    private val increaseCounterUseCase: IncreaseCounterUseCase,
    private val observeCounterUseCase: ObserveCounterUseCase
): ViewModel() {

    private var _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    val counter = observeCounterUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        Settings()
    )
    fun getHelloWorldString() = repository.getHelloWorld()

    fun increaseCounter(value: Int) {
        viewModelScope.launch {
            increaseCounterUseCase(value)
        }
    }

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