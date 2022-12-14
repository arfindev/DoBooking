package com.arfincoding.dobooking.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperation {

    suspend fun saveOnBoardingState(complete: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}