package com.alorma.game_base.calculator

import com.alorma.game_base.Tempura

class TempuraCalculator : Calculator<Tempura> {

    override fun obtainScore(cards: List<Tempura>): Int = (cards.size / 2) * 5
}