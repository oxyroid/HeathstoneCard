package org.oxyroid.hscard.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import heathstonecard.composeapp.generated.resources.JenLe
import heathstonecard.composeapp.generated.resources.Res
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import kotlin.time.Duration.Companion.milliseconds

interface ToastState {
    fun emit(message: String)
    val incoming: SharedFlow<String>
}

@Composable
fun rememberToastState(
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): ToastState {
    return remember(coroutineScope) {
        ToastStateImpl(coroutineScope)
    }
}

internal class ToastStateImpl(
    private val coroutineScope: CoroutineScope,
) : ToastState {
    override fun emit(message: String) {
        coroutineScope.launch {
            incoming.emit(message)
        }
    }

    override val incoming = MutableSharedFlow<String>()
}

@Composable
fun Toast(
    modifier: Modifier = Modifier,
    state: ToastState = rememberToastState(),
) {
    var text: String? by remember { mutableStateOf(null) }
    var isShowing by remember { mutableStateOf(false) }
    val currentAlpha by animateFloatAsState(
        targetValue = if (!isShowing) 0f else 1f,
        animationSpec = tween(800)
    )
    LaunchedEffect(state.incoming) {
        state
            .incoming
            .onEach { msg ->
                text = msg
                isShowing = true
                delay(2400.milliseconds)
                isShowing = false
            }
            .launchIn(this)
    }

    Text(
        text = text.orEmpty(),
        fontFamily = FontFamily(Font(Res.font.JenLe)),
        style = MaterialTheme.typography.headlineMedium,
        modifier = modifier
            .graphicsLayer { alpha = currentAlpha }
            .padding(16.dp)
    )
}
