package com.arfincoding.dobooking.data.remote

import com.arfincoding.dobooking.domain.model.ApiResponse
import com.arfincoding.dobooking.domain.model.Hotel
import retrofit2.http.GET
import retrofit2.http.Query

interface DoBookingApi {

    @GET("/dobooking/hotels")
    suspend fun getAllHotels(): ApiResponse

    @GET("/dobooking/hotels/search")
    suspend fun searchHotel(
        @Query("city") city: String,
        @Query("hotelGuests") hotelGuests: Int,
        @Query("hotelRooms") hotelRooms: Int
    ): ApiResponse

}