package com.bagmanov.helloworldkmp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bagmanov.helloworldkmp.data.battery.BatteryManager
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
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                val counter by viewModel.counter.collectAsStateWithLifecycle()
                var uncensoredText by remember {
                    mutableStateOf("")
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterVertically
                        )
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.office_chair_svgrepo_com),
                            contentDescription = null
                        )
                        Text(text = stringResource(Res.string.hello_world))
                        Text(text = viewModel.getHelloWorldString())
                        Text(text = "Battery level is ${batteryManager.getBatteryLevel()} %")
                        TextField(
                            value = uncensoredText,
                            onValueChange = { uncensoredText = it },
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                            placeholder = {
                                Text("Uncensored text")
                            }
                        )
                        Button(onClick = {
                            viewModel.censorWords(uncensoredText)
                        }
                        ) {
                            if (uiState.isLoading && uncensoredText.isNotBlank()) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .size(15.dp),
                                    strokeWidth = 1.dp,
                                    color = Color.White
                                )
                            } else {
                                Text("Censor!")
                            }
                        }
                        Text(uiState.success)
                        Text(
                            text = uiState.errorMessage,
                            color = Color.Red
                        )
                        Text(
                            text = counter.counter.toString(),
                            textAlign = TextAlign.Center,
                            fontSize = 50.sp
                        )
                        Button(onClick = {
                            val value = counter.counter + 1
                            viewModel.increaseCounter(value)
                        }) {
                            Text("Increment!")
                        }
                    }
                }
            }
        }
    }
}
