package com.gilbersoncampos.detona.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun DetonaNavHost(navController: NavHostController,) {


    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        loginScreen(
            onSignInClick = navController::navigateToHome
        )
        homeScreen(
            onSignOut = navController::navigateToLogin
        )
    }
}



