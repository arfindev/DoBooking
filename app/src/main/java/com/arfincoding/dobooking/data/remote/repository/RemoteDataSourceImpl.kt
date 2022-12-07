package com.arfincoding.dobooking.data.remote.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.arfincoding.dobooking.data.local.DoBookingDatabase
import com.arfincoding.dobooking.data.paging_source.HotelRemoteMediator
import com.arfincoding.dobooking.data.remote.DoBookingApi
import com.arfincoding.dobooking.domain.model.Hotel
import com.arfincoding.dobooking.domain.remote_repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val doBookingDatabase: DoBookingDatabase,
    private val doBookingApi: DoBookingApi
) : RemoteDataSource {

    private val hotelDao = doBookingDatabase.hotelDao

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllHotels(): Flow<PagingData<Hotel>> {
        val pagingSourceFactory = {
            hotelDao.getAllHotels()
        }
        return Pager(
            config = PagingConfig(pageSize = 4),
            remoteMediator = HotelRemoteMediator(
                doBookingApi = doBookingApi, doBookingDatabase = doBookingDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}