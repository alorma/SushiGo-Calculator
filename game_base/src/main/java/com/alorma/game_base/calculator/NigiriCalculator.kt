package com.alorma.game_base.calculator

import com.alorma.game_base.Nigiri

class NigiriCalculator : SinglePlayerCalculator<Nigiri> {

    override fun obtainScore(cards: List<Nigiri>): Int = if (cards.isEmpty()) {
        0
    } else {
        cards.sumBy { card ->
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
}