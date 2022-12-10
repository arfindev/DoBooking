package com.arfincoding.dobooking.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.arfincoding.dobooking.R
import com.arfincoding.dobooking.navigation.Screens
import com.arfincoding.dobooking.ui.theme.LightGreen400
import com.arfincoding.dobooking.ui.theme.RegularFont
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    splashScreenViewModel: SplashScreenViewModel = hiltViewModel(),
    navController: NavController
) {

    val onBoardingCompleted by splashScreenViewModel.onBoardingCompleted.collectAsState()

    LaunchedEffect(key1 = true) {
        delay(1000L)
        navController.popBackStack()
        if (onBoardingCompleted) {
            navController.navigate(Screens.HomeScreen.route)
        } else {
            navController.navigate(Screens.WelcomeScreen.route)
        }
    }
    Splash()


}


@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splashimage),
            contentDescription = "Splash Image", contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0F to Color.Transparent,
                        .5F to Color.Black.copy(alpha = 0.5F),
                        1F to Color.Black.copy(alpha = 0.8F)
                    )
                )
                .padding(30.dp, bottom = 60.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Welcome to",
                fontFamily = RegularFont,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                style = TextStyle(color = Color.White)
            )

            Text(
                text = "DoBooking",
                fontFamily = RegularFont,
                fontWeight = FontWeight.Bold,
                fontSize = 45.sp,
                style = TextStyle(color = LightGreen400)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "The best hotel booking in this century" +
                        " to accompany your vacation",
                fontFamily = RegularFont,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                style = TextStyle(color = Color.White)
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreen(navController = rememberNavController())

}