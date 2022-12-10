package com.arfincoding.dobooking.di

import com.arfincoding.dobooking.data.local.DoBookingDatabase
import com.arfincoding.dobooking.data.remote.DoBookingApi
import com.arfincoding.dobooking.data.remote.repository.RemoteDataSourceImpl
import com.arfincoding.dobooking.data.repository.OnBoardingRepositoryImpl
import com.arfincoding.dobooking.domain.repository.DataStoreOperation
import com.arfincoding.dobooking.domain.repository.OnBoardingRepository
import com.arfincoding.dobooking.domain.repository.RemoteDataSource
import com.arfincoding.dobooking.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesHotelApi(): DoBookingApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(DoBookingApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRemoteDataSourceImpl(
        doBookingApi: DoBookingApi,
        doBookingDatabase: DoBookingDatabase
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            doBookingDatabase = doBookingDatabase,
            doBookingApi = doBookingApi
        )
    }

    @Singleton
    @Provides
    fun providesOnBoardingRepositoryImpl(dataStoreOperation: DataStoreOperation): OnBoardingRepository {
        return OnBoardingRepositoryImpl(dataStoreOperation = dataStoreOperation)
    }


}