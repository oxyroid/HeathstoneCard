package org.oxyroid.hscard.presenter.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import heathstonecard.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.oxyroid.hscard.database
import org.oxyroid.hscard.database.model.MinionCard
import org.oxyroid.hscard.presenter.internal.collectAsPlatformState
import org.oxyroid.hscard.presenter.internal.produce

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
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "home 我的家 JenLe",
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily(Font(Res.font.JenLe))
        )
        Text(
            text = "home 我的家 Benguiat",
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily(Font(Res.font.Benguiat))
        )
        Text(
            text = "home 我的家 YDISapphIIM",
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily(Font(Res.font.YDISapphIIM))
        )
        Text(
            text = "home 我的家 FranklinGothicURWCon_Med",
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily(Font(Res.font.FranklinGothicURWCon_Med))
        )

        val background by produce { Res.readBytes("files/interface/backgrounds/2.jpg") }
        Box(modifier) {
            AsyncImage(
                model = background,
                contentDescription = null
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(minionCards) { minionCard ->
                    ListItem(
                        headlineContent = {
                            Text(
                                text = minionCard.name
                            )
                        }
                    )
                }
            }
            FloatingActionButton(
                onClick = onInsertCard,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null
                )
            }
        }
    }
}
