package com.gilbersoncampos.detona.ui.screens.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gilbersoncampos.detona.data.model.User
import com.gilbersoncampos.detona.data.repository.UserRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: UserRepositoryInterface) :
    ViewModel() {

    private val _homeState = MutableStateFlow<HomeState>(HomeState())
    val homeState: StateFlow<HomeState> = _homeState

    init {
        getUser()
    }

    fun getUser() {
        viewModelScope.launch {
            _homeState.value.isLoading =
                true // Defina isLoading como true antes de começar a obter o usuário
            userRepository.getUser().collect { user ->
                if (user != null) {
                    _homeState.value.user = user
                } else {
                    _homeState.value.user = null
                }
                _homeState.value.isLoading =
                    false // Defina isLoading como false após a conclusão da operação
            }
        }

    }
}

data class HomeState(
    var user: User? = null,
    var isLoading: Boolean = true
)