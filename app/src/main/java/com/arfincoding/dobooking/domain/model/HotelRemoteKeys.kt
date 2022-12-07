package com.arfincoding.dobooking.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dobooking_remote_keys")
data class HotelRemoteKeys(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?

)
