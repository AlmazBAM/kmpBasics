@file:OptIn(ExperimentalTestApi::class)

package com.bagmanov.helloworldkmp

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

class CounterUiTest {
    @Test
    fun counterUiTest() = runComposeUiTest {
        setContent {
            Counter()
        }

        onNodeWithText("0").assertExists()
        onNodeWithText("1").assertDoesNotExist()
        onNodeWithText("Increment").performClick()
        onNodeWithText("1").assertExists()
        onNodeWithText("0").assertDoesNotExist()

    }
}