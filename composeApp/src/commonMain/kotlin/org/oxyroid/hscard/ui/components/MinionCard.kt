package org.oxyroid.hscard.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import heathstonecard.composeapp.generated.resources.JenLe
import heathstonecard.composeapp.generated.resources.Res
import org.oxyroid.hscard.database.model.MinionCard
import org.oxyroid.hscard.presenter.internal.produce


@Composable
fun MinionCard(
    minionCard: MinionCard,
    modifier: Modifier = Modifier
) {
    val container by produce { Res.readBytes("files/types/0/0.png") }
    Box(modifier) {
        AsyncImage(
            model = container,
            contentDescription = null
        )
        Assert(
            path = "files/interface/mana.png",
            alignment = Alignment.TopStart,
            scale = 1.4f,
            translationY = 45f,
            text = "4"
        )
        Assert(
            path = "files/interface/atk.png",
            alignment = Alignment.BottomStart,
            scale = 1.4f,
            text = "3",
            translationX = -15f
        )
        Assert(
            path = "files/interface/hp.png",
            alignment = Alignment.BottomEnd,
            scale = 1.4f,
            text = "6"
        )
        Assert(
            path = "files/types/0/title-ribbon.png",
            alignment = Alignment.Center,
            translationY = 45f,
            text = minionCard.name.take(6),
            fontSize = 32.sp,
            fontResource = Res.font.JenLe,
            textRotationZ = -6.5f,
            textFontWeight = FontWeight.Black,
            textTranslationY = -8f,
            drawStyle = null
        )
    }
}
