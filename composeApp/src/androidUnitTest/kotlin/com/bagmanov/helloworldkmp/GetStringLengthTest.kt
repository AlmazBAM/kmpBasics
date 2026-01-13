package com.bagmanov.helloworldkmp

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class GetStringLengthTest {

    @Test
    fun getStringLength() {
        assertThat(getStringLength("ABC")).isEqualTo(3)
    }
}