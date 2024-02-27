package com.gilbersoncampos.detona.navigation

import androidx.annotation.StringRes
import com.gilbersoncampos.detona.R

sealed class Screen(val route:String, @StringRes val title:Int) {


    object AuthScreen: Screen(route="authentication", title = R.string.login)
    object HomeScreen: Screen(route="home", title = R.string.home)
}