package com.arfincoding.dobooking.data.remote

import com.arfincoding.dobooking.auth.AuthRequest
import com.arfincoding.dobooking.auth.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {


    @POST("signup")
    suspend fun signUp(
        @Body request: AuthRequest
    )

    @POST("signin")
    suspend fun signIn(
        @Body request: AuthRequest
    ): TokenResponse

    @GET("authenticate")
    suspend fun authentication(
        @Header("Authorization") token: String
    )

}