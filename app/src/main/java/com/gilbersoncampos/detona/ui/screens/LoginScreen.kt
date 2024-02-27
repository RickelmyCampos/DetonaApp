package com.gilbersoncampos.detona.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gilbersoncampos.detona.R
import com.gilbersoncampos.detona.ui.comoponents.BaseTextField
import com.gilbersoncampos.detona.ui.comoponents.PrimaryButton
import com.gilbersoncampos.detona.ui.theme.White

@Composable
fun LoginScreen(
    onSignInClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val loading = remember {
        mutableStateOf(false)
    }


    val loginState by loginViewModel.loginState.collectAsState()
    val userAuthenticated by loginViewModel.userAuthenticated.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (loginState is LoginState.Loading) {
            CircularProgressIndicator()
        } else if (loginState is LoginState.Success) {
            LaunchedEffect(userAuthenticated) {
                if (userAuthenticated) {
                    onSignInClick()
                }
            }
        } else {
            Image(
                painter = painterResource(id = R.drawable.detona_logo_login),
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 30.dp)
                    .size(148.dp, 57.dp),
                contentDescription = null
            )
            FormLogin(

                loginViewModel::login, onSignUpClick
            )
            AlternativeLogin()
            TextButton(onClick = onSignUpClick) {
                Text(text = buildAnnotatedString {
                    append("Não possui conta? ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) {
                        append("Cadastre-se")
                    }
                }, color = White)

            }
        }


    }
}

@Composable
fun FormLogin(
    onSignInClick: (user: String, pass: String) -> Unit,
    onForgotPasswordClick: () -> Unit,
) {
    var user by remember {
        mutableStateOf("")
    }
    var pass by remember {
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        BaseTextField(
            label = "Login",
            value = user,
            onValueChange = { user = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        BaseTextField(
            label = "Senha",
            value = pass,
            onValueChange = { pass = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            TextButton(onClick = onForgotPasswordClick) {
                Text(text = "Esqueceu a senha?", color = White)

            }
        }

        PrimaryButton(
            title = "Entrar",
            modifier = Modifier.fillMaxWidth(),
            onClick = { onSignInClick(user, pass) })
    }

}

@Composable
fun AlternativeLogin() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Divider(modifier = Modifier.weight(1f))
            Text(
                text = "OU",
                modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                color = White
            )
            Divider(modifier = Modifier.weight(1f))
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Facebook")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Google")

        }
        Divider()
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    //LoginScreen()
}