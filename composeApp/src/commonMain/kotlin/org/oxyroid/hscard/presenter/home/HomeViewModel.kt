package org.oxyroid.hscard.presenter.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import org.oxyroid.hscard.database.HsDatabase
import org.oxyroid.hscard.database.model.MinionCard
import org.oxyroid.hscard.presenter.internal.stateInWhileSubscribed
import org.oxyroid.hscard.presenter.internal.viewModelScope
import kotlin.random.Random

class HomeViewModel(
    database: HsDatabase,
    coroutineScope: CoroutineScope = viewModelScope()
) : ViewModel(coroutineScope) {
    private val minionCardDao = database.minionCardDao()
    val minionCards: StateFlow<List<MinionCard>> = minionCardDao
        .observeAll()
        .stateInWhileSubscribed(
            scope = viewModelScope,
            initialValue = emptyList()
        )

    fun onInsertCard() {
        viewModelScope.launch {
            val now = Clock.System.now().toString()
            minionCardDao.insert(
                MinionCard(
                    cost = Random.nextInt(10),
                    name = "Name_$now",
                    attack = Random.nextInt(12),
                    defense = Random.nextInt(12),
                    description = "Description_$now",
                    image = "Image_$now",
                    race = MinionCard.Race.None
                )
            )
        }
    }
}
