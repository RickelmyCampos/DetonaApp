package com.gilbersoncampos.detona.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gilbersoncampos.detona.ui.screens.LoginScreen

private val LOGIN = Screen.AuthScreen.route
fun NavGraphBuilder.loginScreen(onSignInClick:()->Unit) {
    composable(route = LOGIN) {
        LoginScreen(onSignInClick=onSignInClick)
    }
}

fun NavController.navigateToLogin() = navigate(LOGIN){
    popUpTo(this@navigateToLogin.graph.findStartDestination().id) {
        inclusive = true
    }
    launchSingleTop = true
}

