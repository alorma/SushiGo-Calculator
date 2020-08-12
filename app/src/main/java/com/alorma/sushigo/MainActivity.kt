package com.alorma.sushigo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alorma.game_base.Game
import com.alorma.game_ui.SushiGoUiCard
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val game = Game(4)

        card1.setCard(SushiGoUiCard(R.color.tomato_l_1, "Maki", "Màs 6 / 3"))
        card2.setCard(SushiGoUiCard(R.color.lavander_l_3, "Tempura", "x2 = 5"))
        card3.setCard(SushiGoUiCard(R.color.bamboo_l_1, "Sashimi", "x3 = 10"))
        card4.setCard(SushiGoUiCard(R.color.starblue_l_3, "Gyoza", "1 3 6 10 15"))

    }
}