package org.oxyroid.hscard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import org.oxyroid.hscard.database.model.MinionCard
import kotlin.math.absoluteValue

@Composable
fun CardGallery(
    cards: List<MinionCard>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val pagerState = rememberPagerState { cards.size }
        val toastState = rememberToastState()
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
                        lerp(
                            start = 0.65f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    }
            ) {
                MinionCard(
                    minionCard = cards[page].copy(name = "恩佐斯"),
                    modifier = Modifier
                )
            }
        }
        val currentCard by remember(cards) {
            derivedStateOf {
                val currentPage = pagerState.currentPage
                if (cards.isEmpty()) null
                else cards[currentPage.coerceIn(0, cards.lastIndex)]
            }
        }
        LaunchedEffect(currentCard) {
            toastState.emit(currentCard?.name.orEmpty())
        }
        Toast(
            state = toastState
        )
    }
}
