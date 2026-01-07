package com.bagmanov.helloworldkmp.dependencies

import androidx.lifecycle.ViewModel

class MainViewModel(
    private val repository: Repository
): ViewModel() {

    fun getHelloWorldString() = repository.getHelloWorld()
}