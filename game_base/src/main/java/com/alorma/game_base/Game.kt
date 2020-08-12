package com.alorma.game_base

class Game(private val numberOfPlayers: Int) {

    fun getNumberOfCardsByRound() = when (numberOfPlayers) {
        2 -> 10
        3 -> 9
        4 -> 8
        5 -> 7
        else -> throw IndexOutOfBoundsException("Max 5 players are allowed")
    }
}