package com.arfincoding.dobooking.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import com.arfincoding.dobooking.domain.model.Hotel
import com.arfincoding.dobooking.presentation.home_screen.HomeViewModel
import com.arfincoding.dobooking.presentation.home_screen.TestHomeScreen
import com.arfincoding.dobooking.ui.theme.LightGreen400
import com.arfincoding.dobooking.ui.theme.RegularFont
import com.arfincoding.dobooking.util.Constant

@Composable
fun HotelItem(
    hotel: Hotel
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(30.dp), elevation = 0.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = rememberAsyncImagePainter(
                    model = "${Constant.BASE_URL}${hotel.hotelThumb}"
                ),
                contentDescription = "Hotel Image",
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(20.dp)
                    )
                    .size(height = 110.dp, width = 20.dp)
                    .weight(2f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxSize()
                    .padding(top = 15.dp)
            ) {
                Text(
                    text = hotel.hotelName,
                    fontFamily = RegularFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = hotel.city,
                    fontFamily = RegularFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    style = TextStyle(color = Color.Gray)

                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$${hotel.hotelPrice}",
                    fontFamily = RegularFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp,
                    style = TextStyle(
                        color = LightGreen400
                    )
                )
                Text(
                    text = "/night",
                    fontFamily = RegularFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    style = TextStyle(color = Color.Gray)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Icon(
                    painter = painterResource(id = com.arfincoding.dobooking.R.drawable.bookmark),
                    contentDescription = "Icon",
                    tint = LightGreen400,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}

@Composable
fun ListContent(
    hotels: LazyPagingItems<Hotel>
) {
    LazyColumn(
        contentPadding = PaddingValues(all = 10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(
            items = hotels,
            key = { hotel ->
                hotel.id
            }) { hotel ->
            hotel?.let { hotel ->
                HotelItem(hotel = hotel)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewListContent() {
    HotelItem(
        hotel = Hotel(
            id = 1,
            city = "Paris, France",
            hotelName = "President Hotel",
            hotelImage = listOf("/images/natyahotel.jpg"),
            hotelDescription = "wjfijskfjasdk",
            hotelReviews = listOf(),
            hotelGuests = 1,
            hotelPrice = 24,
            hotelRooms = 3,
            hotelThumb = ""
        )
    )

}