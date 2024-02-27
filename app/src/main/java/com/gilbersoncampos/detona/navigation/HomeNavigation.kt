package com.gilbersoncampos.detona.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.gilbersoncampos.detona.data.model.User
import com.gilbersoncampos.detona.ui.screens.Home.HomeScreen

private val HOME = Screen.HomeScreen.route
fun NavGraphBuilder.homeScreen( onSignOut: () -> Unit ) {
    composable(route = HOME) {

            HomeScreen(onSignOut)



    }
}

fun NavController.navigateToHome() = navigate(HOME,
    navOptions = navOptions {
        popUpTo(this@navigateToHome.graph.findStartDestination().id) {
            inclusive = true
        }
        launchSingleTop = true

    })