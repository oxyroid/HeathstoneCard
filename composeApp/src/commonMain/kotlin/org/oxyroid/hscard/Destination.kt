package org.oxyroid.hscard

import androidx.compose.runtime.Immutable

@Immutable
enum class Destination(
    val route: String
) {
    HOME("home"),
    EDIT("edit"),
}
