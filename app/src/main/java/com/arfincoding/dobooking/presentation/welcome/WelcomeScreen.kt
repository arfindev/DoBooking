package com.arfincoding.dobooking.presentation.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.arfincoding.dobooking.domain.model.OnBoardingPage
import com.arfincoding.dobooking.navigation.Screens
import com.arfincoding.dobooking.presentation.splash.SplashScreenViewModel
import com.arfincoding.dobooking.ui.theme.LightGreen400
import com.arfincoding.dobooking.ui.theme.RegularFont
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navController: NavController,
    splashScreenViewModel: SplashScreenViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = LightGreen400,
            inactiveColor = Color.Gray,
            indicatorWidth = 10.dp,
            spacing = 5.dp
        )
        PagerButton(modifier = Modifier.weight(3f), pagerState = pagerState) {
            navController.popBackStack()
            navController.navigate(Screens.HomeScreen.route)
            splashScreenViewModel.saveOnBoardingState(completed = true)

        }
    }

}


@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "OnBoarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f), contentScale = ContentScale.Crop
        )
        Text(
            text = onBoardingPage.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 15.dp),
            fontFamily = RegularFont,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.h5.fontSize
        )
        Text(
            text = onBoardingPage.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 15.dp),
            fontFamily = RegularFont,
            color = Color.Gray,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 30.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(visible = pagerState.currentPage == 0 || pagerState.currentPage == 1 || pagerState.currentPage == 2) {
            Button(
                modifier = Modifier.fillMaxWidth().height(50.dp), shape = RoundedCornerShape(30.dp),
                onClick = onClick, colors = ButtonDefaults.buttonColors(
                    backgroundColor = LightGreen400, contentColor = Color.White
                )
            ) {
                Text(text = "Finish", fontFamily = RegularFont, fontWeight = FontWeight.Medium)

            }
        }

    }
}