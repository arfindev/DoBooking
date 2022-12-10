package com.arfincoding.dobooking.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import com.arfincoding.dobooking.R
import com.arfincoding.dobooking.domain.model.Hotel
import com.arfincoding.dobooking.ui.theme.RegularFont
import com.arfincoding.dobooking.util.Constant

@Composable
fun HomeItems(hotel: Hotel) {

    Card(
        modifier = Modifier
            .height(350.dp)
            .width(250.dp), shape = RoundedCornerShape(30.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberAsyncImagePainter(model = "${Constant.BASE_URL}${hotel.hotelThumb}"),
                contentDescription = "hotel image", contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(
                        Brush.verticalGradient(
                            0F to Color.Transparent,
                            .5F to Color.Black.copy(alpha = 0.5F),
                            1F to Color.Black.copy(alpha = 0.8F)
                        )
                    )
            ) {
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = hotel.hotelName,
                    fontWeight = FontWeight.Bold,
                    fontFamily = RegularFont,
                    color = Color.White,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.h4.copy(
                        shadow = Shadow(
                            color = colorResource(id = R.color.black),
                            offset = Offset(x = 0.5f, y = 4f),
                            blurRadius = 0.1f
                        )
                    ),
                )
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = hotel.city,
                    fontWeight = FontWeight.Normal,
                    fontFamily = RegularFont,
                    fontSize = 15.sp,
                    style = TextStyle(color = Color.White)

                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 10.dp, bottom = 25.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "$${hotel.hotelPrice}",
                        fontWeight = FontWeight.Bold,
                        fontFamily = RegularFont,
                        fontSize = 20.sp,
                        style = TextStyle(color = Color.White)

                    )
                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        text = " /per night",
                        fontWeight = FontWeight.Normal,
                        fontFamily = RegularFont,
                        fontSize = 10.sp,
                        style = TextStyle(color = Color.White)

                    )
                }
            }
        }
    }
}
/*

@Preview
@Composable
fun PreviewHomeItem() {
    HomeItems()

}*/
