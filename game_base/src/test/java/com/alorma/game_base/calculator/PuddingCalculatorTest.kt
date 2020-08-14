package com.alorma.game_base.calculator

import com.alorma.game_base.PlayerId
import com.alorma.game_base.Pudding
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class PuddingCalculatorTest {

    @Test
    fun `on player has more puddings sum 6 points`() {
        val players = mapOf(
            PlayerId("1") to listOf(Pudding, Pudding, Pudding),
            PlayerId("2") to listOf(Pudding, Pudding)
        )

        val calculator = PuddingCalculator()

        val result = calculator.obtainScore(PlayerId("1"), players)

        expectThat(result).isEqualTo(6)
    }

    @Test
    fun `on two players has more puddings sum 3 points each`() {
        val players = mapOf(
            PlayerId("1") to listOf(Pudding, Pudding, Pudding),
            PlayerId("2") to listOf(Pudding, Pudding),
            PlayerId("3") to listOf(Pudding, Pudding, Pudding)
        )

        val calculator = PuddingCalculator()

        val result1 = calculator.obtainScore(PlayerId("1"), players)
        expectThat(result1).isEqualTo(3)
        val result3 = calculator.obtainScore(PlayerId("3"), players)
        expectThat(result3).isEqualTo(3)
    }

    @Test
    fun `on seconds player with two players has less puddings sum 0 points`() {
        val players = mapOf(
            PlayerId("1") to listOf(Pudding, Pudding, Pudding),
            PlayerId("2") to listOf(Pudding, Pudding)
        )

        val calculator = PuddingCalculator()

        val result = calculator.obtainScore(PlayerId("2"), players)

        expectThat(result).isEqualTo(0)
    }

    @Test
    fun `on last player with less pudding on three players game substract 6 points`() {
        val players = mapOf(
            PlayerId("1") to listOf(Pudding, Pudding, Pudding),
            PlayerId("2") to listOf(Pudding, Pudding),
            PlayerId("3") to listOf(Pudding)
        )

        val calculator = PuddingCalculator()

        val result = calculator.obtainScore(PlayerId("3"), players)

        expectThat(result).isEqualTo(-6)
    }

    @Test
    fun `on two players with less pudding on many players game substract 3 points each`() {
        val players = mapOf(
            PlayerId("1") to listOf(Pudding, Pudding, Pudding),
            PlayerId("2") to listOf(Pudding, Pudding),
            PlayerId("3") to listOf(Pudding),
            PlayerId("4") to listOf(Pudding)
        )

        val calculator = PuddingCalculator()

        val result3 = calculator.obtainScore(PlayerId("3"), players)
        expectThat(result3).isEqualTo(-3)
        val result4 = calculator.obtainScore(PlayerId("4"), players)
        expectThat(result4).isEqualTo(-3)
    }

}