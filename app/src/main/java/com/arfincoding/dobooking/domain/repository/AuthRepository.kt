package com.arfincoding.dobooking.domain.repository

import com.arfincoding.dobooking.auth.AuthResult

interface AuthRepository {
    suspend fun signUp(
        username: String,
        password: String,
        email: String?,
        mobile: String?,
        address: String?,
        country: String?,
        postcode: String?,
    ): AuthResult<Unit>

    suspend fun signIn(username: String, password: String): AuthResult<Unit>
    suspend fun authentication(): AuthResult<Unit>

}