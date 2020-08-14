package com.alorma.game_base.calculator

import com.alorma.game_base.SushiCard

interface SinglePlayerCalculator<T : SushiCard>: Calculator<T> {
    fun obtainScore(cards: List<T>): Int
}
