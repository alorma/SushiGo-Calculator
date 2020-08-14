package com.alorma.game_base.calculator

import com.alorma.game_base.Sashimi
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class SashimiCalculatorTest {

    @Test
    fun `on 2 sashimi cards sum 0 points`() {
        val cards = listOf(
            Sashimi,
            Sashimi
        )
        val calculator = SashimiCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(0)
    }

    @Test
    fun `on 3 sashimi cards sum 10 points`() {
        val cards = listOf(
            Sashimi,
            Sashimi,
            Sashimi
        )
        val calculator = SashimiCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(10)
    }

    @Test
    fun `on 4 sashimi cards sum 10 points`() {
        val cards = listOf(
            Sashimi,
            Sashimi,
            Sashimi,
            Sashimi
        )
        val calculator = SashimiCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(10)
    }

    @Test
    fun `on 6 sashimi cards sum 20 points`() {
        val cards = listOf(
            Sashimi,
            Sashimi,
            Sashimi,
            Sashimi,
            Sashimi,
            Sashimi
        )
        val calculator = SashimiCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(20)
    }
}