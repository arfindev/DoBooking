package com.arfincoding.dobooking.domain.repository

import androidx.paging.PagingData
import com.arfincoding.dobooking.domain.model.Hotel
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllHotels(): Flow<PagingData<Hotel>>

}