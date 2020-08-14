package com.alorma.game_base.calculator

import com.alorma.game_base.Tempura
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class TempuraCalculatorTest {

    @Test
    fun `on 1 Tempura cards sum 0 points`() {
        val cards = listOf(Tempura)
        val calculator = TempuraCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(0)
    }

    @Test
    fun `on 2 Tempura cards sum 5 points`() {
        val cards = listOf(
            Tempura,
            Tempura
        )
        val calculator = TempuraCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(5)
    }

    @Test
    fun `on 3 Tempura cards sum 5 points`() {
        val cards = listOf(
            Tempura,
            Tempura,
            Tempura
        )
        val calculator = TempuraCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(5)
    }

    @Test
    fun `on 4 Tempura cards sum 5 points`() {
        val cards = listOf(
            Tempura,
            Tempura,
            Tempura,
            Tempura
        )
        val calculator = TempuraCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(10)
    }

    @Test
    fun `on 5 Tempura cards sum 5 points`() {
        val cards = listOf(
            Tempura,
            Tempura,
            Tempura,
            Tempura,
            Tempura
        )
        val calculator = TempuraCalculator()

        val result = calculator.obtainScore(cards)

        expectThat(result).isEqualTo(10)
    }
}