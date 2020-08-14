package com.alorma.game_base

import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class GameTest {

    @Test
    fun `on calculate game return max score player`() {
        val players = listOf(player1, player2, player3)
        val game = Game(players)
        game.updateScore(player1, 4)
        game.updateScore(player2, 10)
        game.updateScore(player3, 15)

        val player = game.calculateWinner()

        expectThat(player).isEqualTo(player3)
    }

    companion object {
        private val player1 = Player(PlayerId("1"), "Player 1")
        private val player2 = Player(PlayerId("2"), "Player 2")
        private val player3 = Player(PlayerId("3"), "Player 3")
    }
}