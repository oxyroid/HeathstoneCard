package org.oxyroid.hscard.presenter.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState

@Composable
fun <T> produce(
    initialValue: T? = null,
    vararg keys: Any?,
    producer: suspend () -> T
): State<T?> {
    return produceState(
        initialValue = initialValue,
        keys = keys
    ) {
        value = producer()
    }
}
