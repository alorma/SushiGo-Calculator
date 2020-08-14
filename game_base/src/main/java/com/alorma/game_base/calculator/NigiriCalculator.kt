package com.alorma.game_base.calculator

import com.alorma.game_base.Nigiri

class NigiriCalculator : Calculator<Nigiri> {
    override fun obtainScore(cards: List<Nigiri>): Int = cards.sumBy { card ->
        val nigiriScore = when (card) {
            is Nigiri.Omelet -> 1
            is Nigiri.Salmon -> 2
            is Nigiri.Squid -> 3
        }
        nigiriScore * if (card.hasWasabi) {
            2
        } else {
            1
        }
    }
}