package com.arfincoding.dobooking.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arfincoding.dobooking.domain.model.Hotel

@Dao
interface HotelDao {

    @Query("SELECT * FROM dobooking")
    fun getAllHotels(): PagingSource<Int, Hotel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHotels(hotels: List<Hotel>)

    @Query("DELETE FROM dobooking")
    suspend fun deleteHotels()


}