package com.arfincoding.dobooking.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arfincoding.dobooking.domain.model.HotelRemoteKeys

@Dao
interface HotelRemoteKeyDao {

    @Query("SELECT * FROM dobooking_remote_keys WHERE id = :id")
    suspend fun getRemoteKey(id: Int): HotelRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKey(hotelRemoteKeys: List<HotelRemoteKeys>)

    @Query("DELETE FROM dobooking_remote_keys")
    suspend fun deleteAllRemoteKeys()


}