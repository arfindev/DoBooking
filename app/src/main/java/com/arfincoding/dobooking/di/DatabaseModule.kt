package com.arfincoding.dobooking.di

import android.content.Context
import androidx.room.Room
import com.arfincoding.dobooking.data.local.DoBookingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesHotelDatabase(@ApplicationContext context: Context): DoBookingDatabase{
        return Room.databaseBuilder(
            context,
            DoBookingDatabase::class.java,
            "DoBooking"
        ).build()
    }

}