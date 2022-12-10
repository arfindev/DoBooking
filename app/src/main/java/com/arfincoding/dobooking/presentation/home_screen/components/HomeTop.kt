package com.arfincoding.dobooking.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import com.arfincoding.dobooking.R
import com.arfincoding.dobooking.domain.model.Hotel
import com.arfincoding.dobooking.ui.theme.LightGreen400
import com.arfincoding.dobooking.ui.theme.RegularFont
import com.arfincoding.dobooking.util.Constant


@Composable
fun HomeTop(hotels: LazyPagingItems<Hotel>) {
    Column(
        modifier = Modifier
            .height(350.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.seminyak),
                contentDescription = "hotel image", contentScale = ContentScale.FillBounds
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Card(
                        modifier = Modifier
                            .height(90.dp)
                            .width(100.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(modifier  =Modifier.size(50.dp),
                                painter = painterResource(id = R.drawable.cocotree),
                                contentDescription = "cocotree"
                            )
                        }


                    }


                }

            }

        }

    }
    Spacer(modifier = Modifier.height(30.dp))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .padding(
                start = 15.dp,
            )
    ) {
        items(
            items = hotels,
            key = { hotel ->
                hotel.id
            }) { hotel ->
            hotel?.let { hotel ->
                HomeItems(hotel = hotel)
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Recently Booked",
            fontFamily = RegularFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )
        Text(
            text = "See All",
            fontFamily = RegularFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            style = TextStyle(color = LightGreen400)
        )
    }

}
