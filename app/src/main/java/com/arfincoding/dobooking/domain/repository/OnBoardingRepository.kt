package com.arfincoding.dobooking.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnBoardingRepository {

    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}