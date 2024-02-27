package com.gilbersoncampos.detona.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gilbersoncampos.detona.R
import com.gilbersoncampos.detona.ui.theme.Yellow
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 3000
@Composable
fun SplashScreen(onTimeout: () -> Unit={},) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow)
    ) {
        val currentOnTimeOut by rememberUpdatedState(newValue =onTimeout )
        LaunchedEffect(Unit){
            delay(SplashWaitTime)
            currentOnTimeOut()
        }
        Image(painter = painterResource(id = R.drawable.detona_logo), contentDescription = null, modifier = Modifier.size(200.dp))
    }
}
@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen()
}