package com.bagmanov.helloworldkmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.bagmanov.helloworldkmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App(
        batteryManager = remember {
            BatteryManager()
        }
    )
}