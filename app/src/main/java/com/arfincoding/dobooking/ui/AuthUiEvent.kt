package com.arfincoding.dobooking.ui

sealed class AuthUiEvent {
    data class SignUpUsernameChanged(val value: String): AuthUiEvent()
    data class SignUpPasswordChanged(val value: String): AuthUiEvent()
    data class SignUpAddressChanged(val value: String?) : AuthUiEvent()
    data class SignUpCountryChanged(val value: String?) : AuthUiEvent()
    data class SignUpPostCodeChanged(val value: String?) : AuthUiEvent()
    data class SignUpMobileChanged(val value: String?) : AuthUiEvent()
    data class SignUpEmailChanged(val value: String?) : AuthUiEvent()
    object SignUp: AuthUiEvent()

    data class SignInUsernameChanged(val value: String): AuthUiEvent()
    data class SignInPasswordChanged(val value: String): AuthUiEvent()
    object SignIn: AuthUiEvent()
}
