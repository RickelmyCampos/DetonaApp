package com.gilbersoncampos.detona.ui.screens.Home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.gilbersoncampos.detona.data.model.User

@Composable
fun HomeScreen(onSignOut: () -> Unit, viewModel: HomeViewModel = hiltViewModel()) {

    val homeState by viewModel.homeState.collectAsState()
    var user: User? by remember {
        mutableStateOf(null)
    }
    var dataState by remember {
        mutableStateOf("loading")
    }
    LaunchedEffect(null) {
        user = homeState.user
        dataState = "finished"
    }
    when (dataState) {
        "loading" -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Carregando...",
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }
        }
        "finished"->{
            user?.let {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Carregado...",
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
            }?: LaunchedEffect(null) {
                onSignOut()
            }
        }

    }


}
