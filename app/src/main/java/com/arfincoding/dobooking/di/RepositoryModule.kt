package com.arfincoding.dobooking.di

import android.content.Context
import com.arfincoding.dobooking.data.repository.DataStoreOperationImpl
import com.arfincoding.dobooking.data.repository.Repository
import com.arfincoding.dobooking.domain.repository.DataStoreOperation
import com.arfincoding.dobooking.domain.repository.OnBoardingRepository
import com.arfincoding.dobooking.domain.repository.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(
        remoteDataSource: RemoteDataSource,
        onBoardingRepository: OnBoardingRepository
    ): Repository {
        return Repository(
            remoteDataSource = remoteDataSource,
            onBoardingRepository = onBoardingRepository
        )
    }

    @Provides
    @Singleton
    fun provideDataStoreOperation(@ApplicationContext context: Context): DataStoreOperation {
        return DataStoreOperationImpl(context = context)
    }

}