package com.arfincoding.dobooking.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arfincoding.dobooking.R
import com.arfincoding.dobooking.ui.theme.RegularFont


@Composable
fun AppTopBar() {


    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        title = {
            Column {
                Text(
                    text = "Arfin Hosain",
                    textAlign = TextAlign.Start,
                    fontFamily = RegularFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    style = TextStyle(color = Color.Black)
                )
            }
        },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "profile image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(
                        CircleShape
                    )
            )
        },
        actions = {
            BadgedBox(
                badge = {
                    Badge(
                        modifier = Modifier
                            .size(0.dp), backgroundColor = Color.Red
                    )
                },
            ) {
                Icon(
                    modifier = Modifier
                        .size(28.dp),
                    painter = painterResource(id = R.drawable.notifications),
                    contentDescription = "",
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            BadgedBox(
                badge = {
                    Badge(
                        modifier = Modifier
                            .size(0.dp), backgroundColor = Color.Red
                    )
                },
            ) {
                Icon(
                    modifier = Modifier
                        .size(28.dp),
                    painter = painterResource(id = R.drawable.bookmark),
                    contentDescription = "",
                    tint = Color.Black,
                )
            }

        },
        backgroundColor = Color.White
    )
}
