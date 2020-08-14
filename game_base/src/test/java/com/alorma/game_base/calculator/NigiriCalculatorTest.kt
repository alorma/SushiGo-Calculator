package com.alorma.game_base.calculator

import com.alorma.game_base.Nigiri
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class NigiriCalculatorTest {

    @Test
    fun `on nigiri cards sum all cards`() {
        val cards = listOf(
            Nigiri.Omelet(),
            Nigiri.Salmon(),
            Nigiri.Squid()
        )
        val calculator = NigiriCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(6)
    }

    @Test
    fun `on nigiri cards with wasabi count double`() {
        val cards = listOf(
            Nigiri.Squid(hasWasabi = true)
        )
        val calculator = NigiriCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(6)
    }

}