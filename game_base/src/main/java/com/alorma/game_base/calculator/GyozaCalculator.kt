package com.alorma.game_base.calculator

import com.alorma.game_base.Gyoza

class GyozaCalculator : SinglePlayerCalculator<Gyoza> {

    override fun obtainScore(cards: List<Gyoza>): Int {
        if (cards.isEmpty()) {
            return 0
        }
        return when (cards.size) {
            1 -> 1
            2 -> 3
            3 -> 6
            4 -> 10
            else -> 15
        }
    }
}