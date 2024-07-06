package org.oxyroid.hscard.ui.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import heathstonecard.composeapp.generated.resources.Res
import org.oxyroid.hscard.presenter.internal.produce

enum class BackgroundType(
    val path: String,
    val contentColor: Color
) {
    Collection("files/interface/backgrounds/0.png", Color.Black),
    Unpacking("files/interface/backgrounds/2.jpg", Color.White)
}

@Composable
fun Background(
    type: BackgroundType,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier) {
        val bytes by produce { Res.readBytes(type.path) }
        AsyncImage(
            model = bytes,
            contentScale = ContentScale.Crop,
            contentDescription = "bg_${type.name}",
            modifier = Modifier.fillMaxSize()
        )
        CompositionLocalProvider(LocalContentColor provides type.contentColor) {
            content()
        }
    }
}
