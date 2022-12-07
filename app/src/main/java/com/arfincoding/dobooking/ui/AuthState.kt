package com.arfincoding.dobooking.ui

data class AuthState(
    val isLoading: Boolean = false,
    val signUpUsername: String = "",
    val signUpPassword: String = "",
    val signUpMobile: String? = "",
    val signUpCountry: String? = "",
    val signUpPostCode: String? = "",
    val signUpEmail: String? = "",
    val signUpAddress : String? = "",
    val signInUsername: String = "",
    val signInPassword: String = ""
)
