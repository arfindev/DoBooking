package com.arfincoding.dobooking.auth

data class AuthRequest(
    val username: String,
    val password: String,
    val email: String?  = null,
    val address: String? = null,
    val postcode: String? = null,
    val country: String? = null,
    val mobile: String? = null
)
