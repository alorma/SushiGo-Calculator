package com.alorma.game_base

sealed class SushiCard

sealed class Nigiri : SushiCard() {
    abstract val hasWasabi: Boolean

    data class Omelet(override val hasWasabi: Boolean = false) : Nigiri()
    data class Salmon(override val hasWasabi: Boolean = false) : Nigiri()
    data class Squid(override val hasWasabi: Boolean = false) : Nigiri()
}

object Sashimi : SushiCard()