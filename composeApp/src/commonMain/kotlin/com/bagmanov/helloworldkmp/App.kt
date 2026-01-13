package com.bagmanov.helloworldkmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bagmanov.helloworldkmp.dependencies.MainViewModel
import helloworldkmp.composeapp.generated.resources.Res
import helloworldkmp.composeapp.generated.resources.hello_world
import helloworldkmp.composeapp.generated.resources.office_chair_svgrepo_com
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App(
    batteryManager: BatteryManager
) {
    MaterialTheme {
        NavHost(
            navController = rememberNavController(),
            startDestination = "home"
        ) {
            composable(route = "home") {
                val viewModel = koinViewModel<MainViewModel>()
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Image(
                            painter = painterResource(Res.drawable.office_chair_svgrepo_com),
                            contentDescription = null
                        )
                        Text(text = stringResource(Res.string.hello_world))
                        Text(text = viewModel.getHelloWorldString())
                        Text(text = "Battery level is ${batteryManager.getBatteryLevel()} %")
                    }
                }
            }
        }
    }
}
