package org.oxyroid.hscard.presenter.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import heathstonecard.composeapp.generated.resources.Benguiat
import heathstonecard.composeapp.generated.resources.JenLe
import heathstonecard.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font
import org.oxyroid.hscard.database
import org.oxyroid.hscard.database.model.MinionCard
import org.oxyroid.hscard.presenter.internal.collectAsPlatformState
import org.oxyroid.hscard.ui.background.Background
import org.oxyroid.hscard.ui.background.BackgroundType
import org.oxyroid.hscard.ui.components.CardGallery

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel { HomeViewModel(database) }
) {
    val minionCards by viewModel.minionCards.collectAsPlatformState()
    HomeScreen(
        minionCards = minionCards,
        modifier = modifier,
        onInsertCard = viewModel::onInsertCard
    )
}

@Composable
private fun HomeScreen(
    minionCards: List<MinionCard>,
    modifier: Modifier = Modifier,
    onInsertCard: () -> Unit
) {
    Background(BackgroundType.Unpacking) {
        CardGallery(
            cards = minionCards,
            modifier = modifier
        )
    }
}
