package com.gilbersoncampos.detona

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gilbersoncampos.detona.navigation.DetonaNavHost
import com.gilbersoncampos.detona.navigation.Screen
import com.gilbersoncampos.detona.ui.screens.LoginViewModel
import com.gilbersoncampos.detona.ui.screens.SplashScreen
import com.gilbersoncampos.detona.ui.theme.DetonaTheme
import com.gilbersoncampos.detona.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetonaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    val currentDestination =
                        navController.currentBackStackEntryAsState().value?.destination
                    val currentAppBarDestination: Screen? = when (currentDestination?.route) {
                        Screen.HomeScreen.route -> Screen.HomeScreen
                        Screen.AuthScreen.route -> Screen.AuthScreen
                        else -> null
                    }
                    var showLandingScreen by rememberSaveable {
                        mutableStateOf(true)
                    }

                    if (showLandingScreen) {
                        SplashScreen(onTimeout = { showLandingScreen = false })
                    } else {
                        Scaffold(topBar = {
                            currentAppBarDestination?.title?.let {
                                if (it != Screen.AuthScreen.title) {
                                    DetonaTopAppBar(titleRes = it,
                                        onActionClick = {},
                                        onNavigationClick = {})
                                }
                            }
                        }) { padding ->
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(padding),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {



                                    DetonaNavHost(

                                        navController = navController
                                    )


                            }
                        }

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetonaTopAppBar(
    @StringRes titleRes: Int,
    onActionClick: () -> Unit,
    onNavigationClick: () -> Unit,
    onNavigationNotificationClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = titleRes), color = White)
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    tint = White
                )
            }
        },
        actions = {
            Row {
                IconButton(onClick = onNavigationNotificationClick) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        tint = White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = onActionClick) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = White
                    )
                }

            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        )

    )
}

@Preview
@Composable
fun DetonaTopAppBarPreview() {
    DetonaTopAppBar(titleRes = R.string.untitled, {}, {})
}


