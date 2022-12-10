package com.arfincoding.dobooking.data.repository

import com.arfincoding.dobooking.domain.repository.DataStoreOperation
import com.arfincoding.dobooking.domain.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OnBoardingRepositoryImpl @Inject constructor(
    private val dataStoreOperation: DataStoreOperation
) : OnBoardingRepository {
    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStoreOperation.saveOnBoardingState(completed)
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStoreOperation.readOnBoardingState()
    }
}