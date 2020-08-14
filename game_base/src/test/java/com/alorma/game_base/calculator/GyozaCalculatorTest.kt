package com.alorma.game_base.calculator

import com.alorma.game_base.Gyoza
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class GyozaCalculatorTest {

    @Test
    fun `with 1 gyoza sum 1 point`() {
        val cards = listOf(Gyoza)

        val calculator = GyozaCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(1)
    }

    @Test
    fun `with 2 gyozas sum 3 points`() {
        val cards = listOf(Gyoza, Gyoza)

        val calculator = GyozaCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(3)
    }

    @Test
    fun `with 3 gyozaz sum 6 point`() {
        val cards = listOf(Gyoza, Gyoza, Gyoza)

        val calculator = GyozaCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(6)
    }

    @Test
    fun `with 4 gyoza sum 10 points`() {
        val cards = listOf(Gyoza, Gyoza, Gyoza, Gyoza)

        val calculator = GyozaCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(10)
    }

    @Test
    fun `with 5 gyoza sum 15 point`() {
        val cards = listOf(Gyoza, Gyoza, Gyoza, Gyoza, Gyoza)

        val calculator = GyozaCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(15)
    }

    @Test
    fun `with 6 gyoza sum 15 point`() {
        val cards = listOf(Gyoza, Gyoza, Gyoza, Gyoza, Gyoza, Gyoza)

        val calculator = GyozaCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(15)
    }
}