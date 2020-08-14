package com.alorma.game_base.calculator

import com.alorma.game_base.SushiCard

interface Calculator<T : SushiCard> {
    fun obtainScore(cards: List<T>): Int
}
