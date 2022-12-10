package com.arfincoding.dobooking.data.remote.repository

import android.content.SharedPreferences
import com.arfincoding.dobooking.auth.AuthRequest
import com.arfincoding.dobooking.auth.AuthResult
import com.arfincoding.dobooking.data.remote.AuthApi
import com.arfincoding.dobooking.domain.repository.AuthRepository
import retrofit2.HttpException

class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val prefs: SharedPreferences
) : AuthRepository {
    override suspend fun signUp(
        username: String,
        password: String,
        email: String?,
        mobile: String?,
        address: String?,
        country: String?,
        postcode: String?,

        ): AuthResult<Unit> {
        return try {
            authApi.signUp(
                request = AuthRequest(
                    username = username,
                    password = password,
                    email = email,
                    country = country,
                    postcode = postcode,
                    mobile = mobile,
                    address = address

                    )
            )
            signIn(username, password)
        } catch (e: HttpException) {
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()

        }
    }

    override suspend fun signIn(username: String, password: String): AuthResult<Unit> {
        return try {
            val response = authApi.signIn(
                request = AuthRequest(
                    username = username,
                    password = password
                )
            )
            prefs.edit().putString("jwt", response.token)
                .apply()
            AuthResult.Authorized()

        } catch (e: HttpException) {
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()

        }
    }

    override suspend fun authentication(): AuthResult<Unit> {
        return try {
            val token = prefs.getString("jwt", null) ?: return AuthResult.Unauthorized()
            authApi.authentication("Bearer $token")
            AuthResult.Authorized()
        } catch (e: HttpException) {
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()

        }
    }
}