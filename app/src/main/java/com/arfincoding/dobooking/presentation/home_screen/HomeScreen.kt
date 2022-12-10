package com.arfincoding.dobooking.presentation.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.arfincoding.dobooking.presentation.common.AppTopBar
import com.arfincoding.dobooking.presentation.common.ListContent
import com.arfincoding.dobooking.presentation.home_screen.components.HomeTop

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val hotelList = homeViewModel.getAllHotels.collectAsLazyPagingItems()

    Scaffold(content = { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            HomeTop(hotels = hotelList)
        }
    }
    )
}