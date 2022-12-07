package com.arfincoding.dobooking.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "DoBooking")
data class Hotel(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val city: String,
    val hotelName: String,
    val hotelImage: List<String>,
    @ColumnInfo(name = "hotelThumb", defaultValue = "")
    val hotelThumb: String,
    //val hotelGallery: List<String>,
    //val hotelDetails: List<String>,
    val hotelDescription: String,
    val hotelReviews: List<String>,
    val hotelPrice: Int,
    val hotelGuests: Int,
    val hotelRooms: Int
)

