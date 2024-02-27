package com.gilbersoncampos.detona.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.gilbersoncampos.detona.data.repository.UserRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepositoryInterface) : ViewModel() {

    private val _userAuthenticated = MutableStateFlow<Boolean>(false)
    val userAuthenticated: StateFlow<Boolean> get() = _userAuthenticated

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(username: String, password: String) {
        if (username.isNotEmpty() && password.isNotEmpty()) {

            _loginState.value = LoginState.Loading
            userRepository.setUser()
            _userAuthenticated.value=true
            _loginState.value= LoginState.Success
        }

    }
}

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    object Success : LoginState()
    data class Error(val message: String) : LoginState()
}