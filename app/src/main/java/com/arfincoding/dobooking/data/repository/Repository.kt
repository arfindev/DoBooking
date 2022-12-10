package com.arfincoding.dobooking.data.repository

import androidx.paging.PagingData
import com.arfincoding.dobooking.domain.model.Hotel
import com.arfincoding.dobooking.domain.repository.OnBoardingRepository
import com.arfincoding.dobooking.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val onBoardingRepository: OnBoardingRepository
) {


    fun getAllHotels(): Flow<PagingData<Hotel>> {
        return remoteDataSource.getAllHotels()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        onBoardingRepository.saveOnBoardingState(completed)
    }

    fun readOnBoardingState():Flow<Boolean>{
        return onBoardingRepository.readOnBoardingState()
    }




}