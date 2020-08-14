package com.alorma.game_base.calculator

import com.alorma.game_base.Tempura

class TempuraCalculator : SinglePlayerCalculator<Tempura> {

    override fun obtainScore(cards: List<Tempura>): Int = if (cards.isEmpty()) {
        0
    } else {
        (cards.size / 2) * 5
    }
}