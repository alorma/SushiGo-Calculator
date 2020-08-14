package com.alorma.game_base.calculator

import com.alorma.game_base.PlayerId
import com.alorma.game_base.SushiCard

interface MultiPlayerCalculator<T : SushiCard> : Calculator<T> {
    fun obtainScore(playerId: PlayerId, cards: Map<PlayerId, List<T>>): Int
}