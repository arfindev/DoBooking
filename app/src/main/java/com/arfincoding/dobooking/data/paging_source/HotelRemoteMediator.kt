package com.arfincoding.dobooking.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.arfincoding.dobooking.data.local.DoBookingDatabase
import com.arfincoding.dobooking.data.remote.DoBookingApi
import com.arfincoding.dobooking.domain.model.Hotel
import com.arfincoding.dobooking.domain.model.HotelRemoteKeys
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class HotelRemoteMediator
@Inject constructor(
    private val doBookingApi: DoBookingApi,
    private val doBookingDatabase: DoBookingDatabase
) : RemoteMediator<Int, Hotel>() {

    private val doBookingDao = doBookingDatabase.hotelDao
    private val hotelRemoteKeyDao = doBookingDatabase.hotelRemoteKeyDao

    override suspend fun initialize(): InitializeAction {
        val currentTime = System.currentTimeMillis()
        val lastUpdated = hotelRemoteKeyDao.getRemoteKey(id = 1)?.lastUpdated ?: 0L
        val cacheTimeOut = 5

        val diffInMinutes = (currentTime - lastUpdated) / 1000 / 60
        return if (diffInMinutes.toInt() <= cacheTimeOut) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }

    }


    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hotel>): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }
            val response = doBookingApi.getAllHotels()
            if (response.hotels.isNotEmpty()) {
                doBookingDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        doBookingDao.deleteHotels()
                        hotelRemoteKeyDao.deleteAllRemoteKeys()
                    }
                }
                val prevPage = response.prevPage
                val nextPage = response.nextPage
                val keys = response.hotels.map { hotel ->
                    HotelRemoteKeys(
                        id = hotel.id,
                        prevPage = prevPage,
                        nextPage = nextPage,
                        lastUpdated = response.latUpdated
                    )
                }
                hotelRemoteKeyDao.addAllRemoteKey(hotelRemoteKeys = keys)
                doBookingDao.addHotels(hotels = response.hotels)

            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }


    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Hotel>): HotelRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { hotel ->
            hotelRemoteKeyDao.getRemoteKey(id = hotel.id)

        }

    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Hotel>): HotelRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { hotel ->
            hotelRemoteKeyDao.getRemoteKey(id = hotel.id)

        }

    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, Hotel>): HotelRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                hotelRemoteKeyDao.getRemoteKey(id = id)
            }
        }
    }
}
