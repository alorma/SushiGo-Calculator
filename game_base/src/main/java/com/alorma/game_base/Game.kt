package com.alorma.game_base

class Game(private val players: List<Player>) {

    private var currentRound: Round = Round.FIRST

    private val scoreCache: MutableMap<PlayerId, MutableList<PlayerScore>> = mutableMapOf()

    fun updateScore(player: Player, score: Int) {
        scoreCache.getOrPut(player.id) { mutableListOf() }.add(
            PlayerScore(currentRound, score)
        )
    }

    fun calculateWinner(): Player {
        val winnerPlayer = scoreCache
            .mapValues { entry -> entry.value.sumBy { playerScore -> playerScore.score } }
            .maxBy { entry -> entry.value }!!.key
        return players.first { it.id == winnerPlayer }
    }
}