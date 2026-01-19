package com.bagmanov.helloworldkmp.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Counter(
    modifier: Modifier = Modifier
) {
    var counter by remember { mutableIntStateOf(0) }
    Text(counter.toString())
    Button({ counter++ }) {
        Text("Increment")
    }
}