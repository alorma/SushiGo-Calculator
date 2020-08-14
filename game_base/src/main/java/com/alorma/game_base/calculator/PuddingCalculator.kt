package com.alorma.game_base.calculator

import com.alorma.game_base.PlayerId
import com.alorma.game_base.Pudding

class PuddingCalculator : MultiPlayerCalculator<Pudding> {

    override fun obtainScore(playerId: PlayerId, cards: Map<PlayerId, List<Pudding>>): Int {
        if (cards.isEmpty()) {
            return 0
        }

        val mapByPuddings: Map<PlayerId, Int> = cards.mapValues { entry ->
            entry.value.size
        }

        val groupsByPuddings: Map<Int, List<PlayerId>> = mapByPuddings.toList()
            .map { (player: PlayerId, puddings: Int) -> puddings to player }
            .groupBy { (puddings: Int) -> puddings }
            .mapValues { it.value.map { (_, player: PlayerId) -> player } }

        val puddingsWithPlayers: List<Pair<Int, List<PlayerId>>> =
            groupsByPuddings.toList().sortedByDescending { (puddings, _) -> puddings }

        val puddingWinners = puddingsWithPlayers.first().second
        val puddingLosers = puddingsWithPlayers.last().second

        return when (playerId) {
            in puddingWinners -> 6 / puddingWinners.size
            in puddingLosers -> if (cards.size == 2) {
                0
            } else {
                -6 / puddingLosers.size
            }
            else -> 0
        }
    }

}