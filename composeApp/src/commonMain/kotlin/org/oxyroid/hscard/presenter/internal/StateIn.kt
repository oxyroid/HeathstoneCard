package org.oxyroid.hscard.presenter.internal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

fun <T> Flow<T>.stateInWhileSubscribed(
    scope: CoroutineScope,
    initialValue: T,
): StateFlow<T> = stateIn(
    scope = scope,
    started = SharingStarted.WhileSubscribed(5_000),
    initialValue = initialValue
)
fun <T> Flow<T>.stateInEagerly(
    scope: CoroutineScope,
    initialValue: T,
): StateFlow<T> = stateIn(
    scope = scope,
    started = SharingStarted.Eagerly,
    initialValue = initialValue
)
fun <T> Flow<T>.stateInLazily(
    scope: CoroutineScope,
    initialValue: T,
): StateFlow<T> = stateIn(
    scope = scope,
    started = SharingStarted.Lazily,
    initialValue = initialValue
)
