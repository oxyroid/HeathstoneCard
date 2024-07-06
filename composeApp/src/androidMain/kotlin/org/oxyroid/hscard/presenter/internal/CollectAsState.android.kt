package org.oxyroid.hscard.presenter.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext

@Composable
actual fun <T> StateFlow<T>.collectAsPlatformState(context: CoroutineContext): State<T> {
    return collectAsStateWithLifecycle(context = context)
}
