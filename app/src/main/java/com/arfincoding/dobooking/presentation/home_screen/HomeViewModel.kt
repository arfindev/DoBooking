package com.arfincoding.dobooking.presentation.home_screen

import androidx.lifecycle.ViewModel
import com.arfincoding.dobooking.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val getAllHotels = repository.getAllHotels()
}