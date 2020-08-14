package com.alorma.game_base.calculator

import com.alorma.game_base.*
import org.junit.Test
import strikt.api.expect
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isGreaterThan

class RoundCalculatorTest {

    private val calculator = RoundCalculator(
        gyozaCalculator,
        makiCalculator,
        nigiriCalculator,
        puddingCalculator,
        sashimiCalculator,
        tempuraCalculator
    )

    @Test
    fun `on only nigiris return sum`() {
        val cards = mapOf(
            PlayerId("1") to listOf(
                Nigiri.Omelet(),
                Nigiri.Salmon(),
                Nigiri.Squid()
            )
        )

        val result = calculator.obtainScore(PlayerId("1"), cards)

        expectThat(result).isEqualTo(6)
    }

    @Test
    fun `on nigiris and 4 sashimi return sum`() {
        val cards = mapOf(
            PlayerId("1") to listOf(
                Nigiri.Omelet(),
                Nigiri.Salmon(),
                Nigiri.Squid(),
                Sashimi,
                Sashimi,
                Sashimi,
                Sashimi
            )
        )

        val result = calculator.obtainScore(PlayerId("1"), cards)

        expectThat(result).isEqualTo(16)
    }

    @Test
    fun `on players with makis and same nigirs wind player with most makis`() {
        val cards = mapOf(
            PlayerId("1") to listOf(
                Nigiri.Omelet(),
                Nigiri.Salmon(),
                Nigiri.Squid(),
                Maki(3),
                Maki(1)
            ),
            PlayerId("2") to listOf(
                Nigiri.Omelet(),
                Nigiri.Salmon(),
                Nigiri.Squid(),
                Maki(2),
                Maki(3)
            )
        )

        val result1 = calculator.obtainScore(PlayerId("1"), cards)
        val result2 = calculator.obtainScore(PlayerId("2"), cards)

        expect {
            that(result2).isGreaterThan(result1)
            that(result1).isEqualTo(9)
            that(result2).isEqualTo(12)
        }
    }
    @Test
    fun `on players with same cards wins player with dessert`() {
        val cards = mapOf(
            PlayerId("1") to listOf(
                Nigiri.Omelet(),
                Nigiri.Salmon(),
                Nigiri.Squid(),
                Maki(3),
                Maki(1),
                Tempura,
                Tempura,
                Gyoza,
                Gyoza,
                Gyoza
            ),
            PlayerId("2") to listOf(
                Nigiri.Omelet(),
                Nigiri.Salmon(),
                Nigiri.Squid(),
                Maki(3),
                Maki(1),
                Tempura,
                Tempura,
                Gyoza,
                Gyoza,
                Gyoza,
                Pudding
            )
        )

        val result1 = calculator.obtainScore(PlayerId("1"), cards)
        val result2 = calculator.obtainScore(PlayerId("2"), cards)

        expect {
            that(result2).isGreaterThan(result1)
            that(result1).isEqualTo(20)
            that(result2).isEqualTo(26)
        }
    }

    companion object {
        private val gyozaCalculator = GyozaCalculator()
        private val makiCalculator = MakiCalculator()
        private val nigiriCalculator = NigiriCalculator()
        private val puddingCalculator = PuddingCalculator()
        private val sashimiCalculator = SashimiCalculator()
        private val tempuraCalculator = TempuraCalculator()
    }

}