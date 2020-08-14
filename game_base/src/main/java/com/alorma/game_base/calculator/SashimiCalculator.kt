package com.alorma.game_base.calculator

import com.alorma.game_base.Sashimi

class SashimiCalculator : SinglePlayerCalculator<Sashimi> {

    override fun obtainScore(cards: List<Sashimi>): Int = (cards.size / 3) * 10
}