package com.arfincoding.dobooking.di

import com.arfincoding.dobooking.data.repository.Repository
import com.arfincoding.dobooking.domain.remote_repository.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(remoteDataSource: RemoteDataSource): Repository {
        return Repository(remoteDataSource = remoteDataSource)
    }

}