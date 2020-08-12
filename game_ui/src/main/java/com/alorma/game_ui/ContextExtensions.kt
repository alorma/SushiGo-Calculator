package com.alorma.game_ui

import android.content.Context
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.FloatRange
import androidx.core.content.ContextCompat
import com.google.android.material.color.MaterialColors
import kotlin.math.roundToInt

fun Context.getMergedColor(
    @AttrRes backgroundColorAttributeResId: Int = R.attr.colorSurface,
    @ColorInt overlayColor: Int,
    @FloatRange(from = 0.0, to = 1.0) overlayAlpha: Float
): Int {
    val surfaceColor = MaterialColors.getColor(this, backgroundColorAttributeResId, "")
    val colorWithAlpha = overlayColor.let {
        MaterialColors.compositeARGBWithAlpha(it, (255 * overlayAlpha).roundToInt())
    }
    return MaterialColors.layer(surfaceColor, colorWithAlpha)
}
