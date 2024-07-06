package org.oxyroid.hscard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.oxyroid.hscard.presenter.home.HomeRoute

@Composable
fun App(
    modifier: Modifier = Modifier
) {
    MaterialTheme {
        NavHost(
            navController = rememberNavController(),
            startDestination = Destination.HOME.route,
            modifier = modifier.fillMaxSize()
        ) {
            composable(Destination.HOME.route) {
                HomeRoute()
            }
            composable(Destination.EDIT.route) {

            }
        }
    }
}
