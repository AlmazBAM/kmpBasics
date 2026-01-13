package com.bagmanov.helloworldkmp

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test


class GetInitialsTest {


    @Test
    fun getInitialsShort() {
        val fullName = "Phillip"

        assertThat(getInitials(fullName)).isEqualTo("PH")
    }

    @Test
    fun getInitialsMiddle() {
        val fullName = "Phillip Lackner"

        assertThat(getInitials(fullName)).isEqualTo("PL")
    }

    @Test
    fun getInitialsLong() {
        val fullName = "Phillip Middle Lackner"

        assertThat(getInitials(fullName)).isEqualTo("PL")
    }
}