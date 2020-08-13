package com.alorma.game_ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.color.MaterialColors
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import kotlinx.android.synthetic.main.sushi_go_card.view.*
import java.util.*

class SusiGoCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val mediumShape = ShapeAppearanceModel.builder(
        context,
        attrs,
        R.attr.shapeAppearanceMediumComponent,
        R.style.ShapeAppearance_MaterialComponents_MediumComponent
    ).build()

    private val tableBackground = MaterialShapeDrawable(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    init {
        LayoutInflater.from(context).inflate(R.layout.sushi_go_card, this, true)
        sushiGoCardTable.background = createTableDrawable()
    }

    private fun createTableDrawable(): Drawable {
        tableBackground.initializeElevationOverlay(context)
        val color = context.getMergedColor(
            overlayColor = MaterialColors.getColor(this@SusiGoCardView, R.attr.colorGameTable),
            overlayAlpha = 0.5f
        )
        tableBackground.fillColor = ColorStateList.valueOf(color)

        val tableShape = ShapeAppearanceModel.builder()
            .setBottomLeftCorner(mediumShape.bottomLeftCorner)
            .setBottomLeftCornerSize(mediumShape.bottomLeftCornerSize)
            .setBottomEdge(mediumShape.bottomEdge)
            .setBottomRightCornerSize(mediumShape.bottomRightCornerSize)
            .setBottomRightCorner(mediumShape.bottomRightCorner)
            .build()
        tableBackground.shapeAppearanceModel = tableShape


        return tableBackground
    }

    fun setCard(sushiGoCard: SushiGoUiCard) {
        val color = context.getMergedColor(
            overlayColor = ContextCompat.getColor(context, sushiGoCard.color),
            overlayAlpha = 0.6f
        )
        setBackgroundColor(color)

        val textColor = context.getMergedColor(
            overlayColor = ContextCompat.getColor(context, sushiGoCard.color),
            overlayAlpha = 1f
        )
        sushiGoCardType.setTextColor(textColor)

        sushiGoCardType.text = sushiGoCard.type.toUpperCase(Locale.getDefault())
        sushiGoCardPoints.text = sushiGoCard.points
    }

}