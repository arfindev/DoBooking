package com.arfincoding.dobooking.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import com.arfincoding.dobooking.domain.model.Hotel
import com.arfincoding.dobooking.util.Constant.BASE_URL

@Composable
fun TestHomeScreen(
    hotel: Hotel
) {
    val painter = rememberAsyncImagePainter(model = "$BASE_URL${hotel.hotelImage}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
            },
    ) {

        hotel.hotelImage.forEachIndexed { index, images ->
            Image(
                modifier = Modifier.size(100.dp),
                painter = rememberAsyncImagePainter(model = "$BASE_URL${images}"),
                contentDescription = "Hero Image",
                contentScale = ContentScale.Crop
            )

        }
    }
    Text(text = hotel.hotelName)




}

@Composable
fun MainHomeScreen(
    hotel: LazyPagingItems<Hotel>
) {


    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(
            items = hotel,
            key = { hotel ->
                hotel.id
            }) { hotel ->
            hotel?.let {
                TestHomeScreen(hotel = it)
            }
        }
    }
}

@Composable
fun MainMainHomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val hotels = homeViewModel.getAllHotels.collectAsLazyPagingItems()

    MainHomeScreen(hotel = hotels)

}
