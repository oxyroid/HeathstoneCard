package org.oxyroid.hscard.presenter.internal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

actual fun viewModelScope(): CoroutineScope {
    return CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())
}
