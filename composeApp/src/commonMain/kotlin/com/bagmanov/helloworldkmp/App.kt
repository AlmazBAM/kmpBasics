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
import helloworldkmp.composeapp.generated.resources.Res
import helloworldkmp.composeapp.generated.resources.compose_multiplatform
import helloworldkmp.composeapp.generated.resources.hello_world
import helloworldkmp.composeapp.generated.resources.office_chair_svgrepo_com
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    batteryManager: BatteryManager
) {
    MaterialTheme {
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
                Text(text = "Battery level is ${batteryManager.getBatteryLevel()} %")
            }
        }
    }
}