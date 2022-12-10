package com.arfincoding.dobooking.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arfincoding.dobooking.auth.AuthResult
import com.arfincoding.dobooking.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    var state by mutableStateOf(AuthState())
    private val resultChannel = Channel<AuthResult<Unit>>()
    val authResults = resultChannel.receiveAsFlow()

    init {
        authenticate()
    }


    fun onEvent(event: AuthUiEvent) {
        when (event) {
            is AuthUiEvent.SignInUsernameChanged -> {
                state = state.copy(signInUsername = event.value)
            }
            is AuthUiEvent.SignInPasswordChanged -> {
                state = state.copy(signInPassword = event.value)
            }
            is AuthUiEvent.SignIn -> {
                signIn()
            }
            is AuthUiEvent.SignUpUsernameChanged -> {
                state = state.copy(signUpUsername = event.value)
            }
            is AuthUiEvent.SignUpPasswordChanged -> {
                state = state.copy(signUpPassword = event.value)
            }
            is AuthUiEvent.SignUpPostCodeChanged -> {
                state = state.copy(signUpPostCode = event.value)
            }
            is AuthUiEvent.SignUpMobileChanged -> {
                state = state.copy(signUpMobile = event.value)
            }
            is AuthUiEvent.SignUpCountryChanged -> {
                state = state.copy(signUpCountry = event.value)
            }
            is AuthUiEvent.SignUpEmailChanged -> {
                state = state.copy(signUpEmail = event.value)
            }
            is AuthUiEvent.SignUpAddressChanged -> {
                state = state.copy(signUpAddress = event.value)
            }
            is AuthUiEvent.SignUp -> {
                signUp()
            }
        }

    }

    private fun signUp() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.signUp(
                username = state.signUpUsername,
                password = state.signUpPassword,
                email = state.signUpEmail,
                mobile = state.signUpMobile,
                country = state.signUpCountry,
                postcode = state.signUpPostCode,
                address = state.signUpAddress
            )
            resultChannel.send(result)
            state = state.copy(isLoading = false)

        }
    }

    private fun signIn() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.signIn(
                username = state.signInUsername,
                password = state.signInPassword
            )
            resultChannel.send(result)
            state = state.copy(isLoading = false)

        }
    }

    private fun authenticate() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.authentication()
            resultChannel.send(result)
            state = state.copy(isLoading = false)

        }
    }
}