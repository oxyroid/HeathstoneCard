package org.oxyroid.hscard.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import heathstonecard.composeapp.generated.resources.Res
import org.oxyroid.hscard.database.model.MinionCard
import org.oxyroid.hscard.presenter.internal.produce

@Composable
fun MinionCard(
    minionCard: MinionCard,
    modifier: Modifier = Modifier
) {
    val background by produce { Res.readBytes("files/interface/backgrounds/2.jpg") }
    Box(modifier) {
        AsyncImage(
            model = background,
            contentDescription = null,
        )
    }
}
