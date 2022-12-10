package com.arfincoding.dobooking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arfincoding.dobooking.presentation.home_screen.HomeScreen
import com.arfincoding.dobooking.presentation.signin_screen.SignInScreen
import com.arfincoding.dobooking.presentation.splash.SplashScreen
import com.arfincoding.dobooking.presentation.welcome.WelcomeScreen
import com.arfincoding.dobooking.ui.AuthScreen
import com.arfincoding.dobooking.ui.SecretScreen

@Composable
fun NavigationGraph(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = Screens.HomeScreen.route) {
        composable(route = Screens.AuthScreen.route) {
            SignInScreen(navController = navHostController)
        }
        composable(route = Screens.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = Screens.WelcomeScreen.route) {
            WelcomeScreen(navController = navHostController)

        }
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController = navHostController)
        }
    }


}