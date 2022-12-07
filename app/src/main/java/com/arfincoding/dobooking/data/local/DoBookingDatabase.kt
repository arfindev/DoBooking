package com.arfincoding.dobooking.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arfincoding.dobooking.data.local.dao.DatabaseConverter
import com.arfincoding.dobooking.data.local.dao.HotelDao
import com.arfincoding.dobooking.data.local.dao.HotelRemoteKeyDao
import com.arfincoding.dobooking.domain.model.Hotel
import com.arfincoding.dobooking.domain.model.HotelRemoteKeys

@Database(
    entities = [Hotel::class, HotelRemoteKeys::class], version = 2,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)
@TypeConverters(DatabaseConverter::class)
abstract class DoBookingDatabase : RoomDatabase() {

    abstract val hotelDao: HotelDao
    abstract val hotelRemoteKeyDao: HotelRemoteKeyDao

}