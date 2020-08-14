package com.alorma.game_base.calculator

import com.alorma.game_base.*

class RoundCalculator(
    private val gyozaCalculator: SinglePlayerCalculator<Gyoza>,
    private val makiCalculator: MultiPlayerCalculator<Maki>,
    private val nigiriCalculator: SinglePlayerCalculator<Nigiri>,
    private val puddingCalculator: MultiPlayerCalculator<Pudding>,
    private val sashimiCalculator: SinglePlayerCalculator<Sashimi>,
    private val tempuraCalculator: SinglePlayerCalculator<Tempura>
) : MultiPlayerCalculator<SushiCard> {

    override fun obtainScore(playerId: PlayerId, cards: Map<PlayerId, List<SushiCard>>): Int {
        val playerScores = cards.mapValues { (_, playerCards) ->
            val gyozaList = playerCards.filterIsInstance<Gyoza>()
            val makiList = cards.mapValues { it.value.filterIsInstance<Maki>() }
            val nigiriList = playerCards.filterIsInstance<Nigiri>()
            val puddingList = cards.mapValues { it.value.filterIsInstance<Pudding>() }
            val sashimiList = playerCards.filterIsInstance<Sashimi>()
            val tempuraList = playerCards.filterIsInstance<Tempura>()

            val gyozaScore = gyozaCalculator.obtainScore(gyozaList)
            val makiScore = makiCalculator.obtainScore(playerId, makiList)
            val nigiriScore = nigiriCalculator.obtainScore(nigiriList)
            val puddingScore = puddingCalculator.obtainScore(playerId, puddingList)
            val sashimiScore = sashimiCalculator.obtainScore(sashimiList)
            val tempuraScore = tempuraCalculator.obtainScore(tempuraList)

            gyozaScore + makiScore + nigiriScore + puddingScore + sashimiScore + tempuraScore
        }

        return playerScores.getOrElse(playerId) { 0 }
    }

}