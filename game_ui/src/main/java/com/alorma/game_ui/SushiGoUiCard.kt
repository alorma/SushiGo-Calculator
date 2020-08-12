package com.alorma.game_ui

import androidx.annotation.ColorRes

data class SushiGoUiCard(
    @ColorRes val color: Int,
    val type: String,
    val points: String
)