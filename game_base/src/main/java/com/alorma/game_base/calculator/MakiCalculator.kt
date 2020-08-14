package com.alorma.game_base.calculator

import com.alorma.game_base.Maki
import com.alorma.game_base.PlayerId

class MakiCalculator : MultiPlayerCalculator<Maki> {

    override fun obtainScore(playerId: PlayerId, cards: Map<PlayerId, List<Maki>>): Int {
        if (cards.isEmpty()) {
            return 0
        }

        val mapByMakis: Map<PlayerId, Int> = cards.mapValues { entry ->
            entry.value.sumBy { maki -> maki.numberOfMakis }
        }

        val groupsByMakis: Map<Int, List<PlayerId>> = mapByMakis.toList()
            .map { (player: PlayerId, makis: Int) -> makis to player }
            .groupBy { (makis: Int) -> makis }
            .mapValues { it.value.map { (_, player: PlayerId) -> player } }

        val makisWithPlayers: List<Pair<Int, List<PlayerId>>> =
            groupsByMakis.toList().sortedByDescending { (makis, _) -> makis }

        return when (groupsByMakis.size) {
            1 -> 6 / makisWithPlayers.first().second.size
            2 -> {
                when {
                    makisWithPlayers.first().second.contains(playerId) -> 6 / makisWithPlayers.first().second.size
                    makisWithPlayers[1].second.contains(playerId) -> 3 / makisWithPlayers[1].second.size
                    else -> 0
                }
            }
            else -> 0
        }
    }
}
