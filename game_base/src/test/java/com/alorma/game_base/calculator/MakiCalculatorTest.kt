package com.alorma.game_base.calculator

import com.alorma.game_base.Maki
import com.alorma.game_base.PlayerId
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class MakiCalculatorTest {

    @Test
    fun `on player has more makis sum 6 points`() {
        val calculator = MakiCalculator()

        val players = mapOf(
            PlayerId("1") to listOf(Maki(1), Maki(2), Maki(3)),
            PlayerId("2") to listOf(Maki(1), Maki(3))
        )

        val result = calculator.obtainScore(PlayerId("1"), players)

        expectThat(result).isEqualTo(6)
    }

    @Test
    fun `on player is second with more makis sum 3 points`() {
        val calculator = MakiCalculator()

        val players = mapOf(
            PlayerId("1") to listOf(Maki(1), Maki(2), Maki(3)),
            PlayerId("2") to listOf(Maki(1), Maki(3))
        )

        val result = calculator.obtainScore(PlayerId("2"), players)

        expectThat(result).isEqualTo(3)
    }

    @Test
    fun `on player is third with more makis sum 0 points`() {
        val calculator = MakiCalculator()

        val players = mapOf(
            PlayerId("1") to listOf(Maki(1), Maki(2), Maki(3)),
            PlayerId("2") to listOf(Maki(1), Maki(3)),
            PlayerId("3") to listOf(Maki(1), Maki(1))
        )

        val result = calculator.obtainScore(PlayerId("3"), players)

        expectThat(result).isEqualTo(0)
    }

    @Test
    fun `on two players has same max makis sum 3 points`() {
        val calculator = MakiCalculator()

        val players = mapOf(
            PlayerId("1") to listOf(Maki(1), Maki(2), Maki(3)),
            PlayerId("2") to listOf(Maki(1), Maki(2), Maki(3))
        )

        val result1 = calculator.obtainScore(PlayerId("1"), players)
        expectThat(result1).isEqualTo(3)
        val result2 = calculator.obtainScore(PlayerId("2"), players)
        expectThat(result2).isEqualTo(3)
    }

    @Test
    fun `on three players has same max makis sum 2 points`() {
        val calculator = MakiCalculator()

        val players = mapOf(
            PlayerId("1") to listOf(Maki(1), Maki(2), Maki(3)),
            PlayerId("2") to listOf(Maki(1), Maki(2), Maki(3)),
            PlayerId("3") to listOf(Maki(1), Maki(2), Maki(3))
        )

        val result1 = calculator.obtainScore(PlayerId("1"), players)
        expectThat(result1).isEqualTo(2)
        val result2 = calculator.obtainScore(PlayerId("2"), players)
        expectThat(result2).isEqualTo(2)
        val result3 = calculator.obtainScore(PlayerId("3"), players)
        expectThat(result3).isEqualTo(2)
    }

    @Test
    fun `on two players has same second max makis sum 1 point`() {
        val calculator = MakiCalculator()

        val players = mapOf(
            PlayerId("0") to listOf(Maki(2), Maki(2), Maki(3)),
            PlayerId("1") to listOf(Maki(1), Maki(2), Maki(3)),
            PlayerId("2") to listOf(Maki(1), Maki(2), Maki(3))
        )

        val result1 = calculator.obtainScore(PlayerId("1"), players)
        expectThat(result1).isEqualTo(1)
        val result2 = calculator.obtainScore(PlayerId("2"), players)
        expectThat(result2).isEqualTo(1)
    }

    @Test
    fun `on three players has same second max makis sum 1 point`() {
        val calculator = MakiCalculator()

        val players = mapOf(
            PlayerId("0") to listOf(Maki(2), Maki(2), Maki(3)),
            PlayerId("1") to listOf(Maki(1), Maki(2), Maki(3)),
            PlayerId("2") to listOf(Maki(1), Maki(2), Maki(3)),
            PlayerId("3") to listOf(Maki(1), Maki(2), Maki(3))
        )

        val result1 = calculator.obtainScore(PlayerId("1"), players)
        expectThat(result1).isEqualTo(1)
        val result2 = calculator.obtainScore(PlayerId("2"), players)
        expectThat(result2).isEqualTo(1)
        val result3 = calculator.obtainScore(PlayerId("3"), players)
        expectThat(result2).isEqualTo(1)
    }

}