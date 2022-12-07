package com.arfincoding.dobooking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arfincoding.dobooking.presentation.common.ShowListOfItem
import com.arfincoding.dobooking.presentation.home_screen.MainMainHomeScreen
import com.arfincoding.dobooking.ui.SecretScreen

@Composable
fun NavigationGraph(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = Screens.AuthScreen.route) {
        composable(route = Screens.AuthScreen.route){
            ShowListOfItem()
            //MainMainHomeScreen()
            //SignInScreen(navController = navHostController)
            //AuthScreen(navController = navHostController)
        }
        composable(route  = Screens.HomeScreen.route){
            SecretScreen()
        }
    }


}