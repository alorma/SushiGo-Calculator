package com.alorma.game_base

import java.security.InvalidParameterException

sealed class SushiCard

sealed class Nigiri : SushiCard() {
    abstract val hasWasabi: Boolean

    data class Omelet(override val hasWasabi: Boolean = false) : Nigiri()
    data class Salmon(override val hasWasabi: Boolean = false) : Nigiri()
    data class Squid(override val hasWasabi: Boolean = false) : Nigiri()
}

object Tempura : SushiCard()
object Sashimi : SushiCard()

data class Maki(val numberOfMakis: Int) : SushiCard() {
    init {
        if (numberOfMakis !in 1..3) {
            throw InvalidParameterException("Invalid number of makis (1..3")
        }
    }
}