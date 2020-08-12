package com.alorma.game_ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.google.android.material.card.MaterialCardView
import com.google.android.material.color.MaterialColors
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import kotlinx.android.synthetic.main.sushi_go_card.view.*
import java.util.*

class SusiGoCardView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : MaterialCardView(context, attributeSet, defStyleAttr) {

    @SuppressLint("PrivateResource")
    private var tableCardElevation = context.resources.getDimension(R.dimen.mtrl_card_elevation)

    init {
        LayoutInflater.from(context).inflate(R.layout.sushi_go_card, this, true)

        context.withStyledAttributes(
            attributeSet,
            com.google.android.material.R.styleable.CardView,
            defStyleAttr,
            defStyleRes
        ) {
            readProperties()
            sushiGoCardTable.background = createTableDrawable()
        }
    }

    private fun createTableDrawable(): Drawable =
        MaterialShapeDrawable.createWithElevationOverlay(context).apply {
            elevation = tableCardElevation

            val color = context.getMergedColor(
                overlayColor = MaterialColors.getColor(this@SusiGoCardView, R.attr.colorGameTable),
                overlayAlpha = 0.5f
            )
            fillColor = ColorStateList.valueOf(color)
            strokeWidth = 0f

            val cardShape = this@SusiGoCardView.shapeAppearanceModel
            val tableShape = ShapeAppearanceModel.builder()
                .setBottomLeftCorner(cardShape.bottomLeftCorner)
                .setBottomLeftCornerSize(cardShape.bottomLeftCornerSize)
                .setBottomEdge(cardShape.bottomEdge)
                .setBottomRightCornerSize(cardShape.bottomRightCornerSize)
                .setBottomRightCorner(cardShape.bottomRightCorner)
                .build()
            shapeAppearanceModel = tableShape
        }

    @SuppressLint("PrivateResource")
    private fun TypedArray.readProperties() {
        tableCardElevation = getDimension(
            com.google.android.material.R.styleable.CardView_cardElevation,
            tableCardElevation
        )
    }

    fun setCard(sushiGoCard: SushiGoUiCard) {
        val color = context.getMergedColor(
            overlayColor = ContextCompat.getColor(context, sushiGoCard.color),
            overlayAlpha = 0.6f
        )
        setCardBackgroundColor(color)

        val textColor = context.getMergedColor(
            overlayColor = ContextCompat.getColor(context, sushiGoCard.color),
            overlayAlpha = 1f
        )
        sushiGoCardType.setTextColor(textColor)

        sushiGoCardType.text = sushiGoCard.type.toUpperCase(Locale.getDefault())
        sushiGoCardPoints.text = sushiGoCard.points
    }

}