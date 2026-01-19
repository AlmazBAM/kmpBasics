package com.bagmanov.helloworldkmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.bagmanov.helloworldkmp.di.initKoin
import com.bagmanov.helloworldkmp.presentation.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App(
        batteryManager = remember {
            com.bagmanov.helloworldkmp.data.battery.BatteryManager()
        }
    )
}