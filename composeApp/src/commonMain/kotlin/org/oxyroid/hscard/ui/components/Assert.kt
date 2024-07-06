package org.oxyroid.hscard.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import heathstonecard.composeapp.generated.resources.BelweBT_Bold
import heathstonecard.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource
import org.oxyroid.hscard.presenter.internal.produce

@Composable
fun BoxScope.Assert(
    path: String,
    alignment: Alignment,
    scale: Float = 1f,
    translationX: Float = 0f,
    translationY: Float = 0f,
    textRotationZ: Float = 0f,
    textTranslationX: Float = 0f,
    textTranslationY: Float = 0f,
    textFontWeight: FontWeight = FontWeight.Medium,
    text: String = "",
    fontSize: TextUnit = 48.sp,
    fontResource: FontResource = Res.font.BelweBT_Bold,
    shadowInc: Int = 0,
    drawStyle: DrawStyle? = Stroke(
        miter = 8f,
        width = 3f,
        join = StrokeJoin.Round
    )
) {
    val bytes by produce { Res.readBytes(path) }
    val fontFamily = FontFamily(Font(fontResource))
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .align(alignment)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                this.translationX = translationX
                this.translationY = translationY
            }
    ) {
        AsyncImage(
            model = bytes,
            contentDescription = null
        )
        Text(
            text = text,
            style = TextStyle(
                fontFamily = fontFamily,
                color = Color.White,
                fontSize = fontSize,
                baselineShift = BaselineShift.Superscript,
                fontWeight = textFontWeight,
            ),
            modifier = Modifier
                .padding(bottom = 6.dp)
                .graphicsLayer {
                    this.rotationZ = textRotationZ
                    this.translationX = textTranslationX
                    this.translationY = textTranslationY
                }
        )
        if (drawStyle != null) {
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = fontFamily,
                    color = Color.Black,
                    fontSize = (fontSize.value + shadowInc).sp,
                    baselineShift = BaselineShift.Superscript,
                    drawStyle = drawStyle,
                    fontWeight = textFontWeight
                ),
                modifier = Modifier
                    .padding(bottom = 6.dp)
                    .graphicsLayer {
                        this.rotationZ = textRotationZ
                        this.translationX = textTranslationX
                        this.translationY = textTranslationY
                    }
            )
        }
    }
}
