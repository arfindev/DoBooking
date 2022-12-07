package com.arfincoding.dobooking.data.repository

import androidx.paging.PagingData
import com.arfincoding.dobooking.domain.model.Hotel
import com.arfincoding.dobooking.domain.remote_repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) {


    fun getAllHotels(): Flow<PagingData<Hotel>> {
        return remoteDataSource.getAllHotels()
    }

}