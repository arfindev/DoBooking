package com.arfincoding.dobooking.navigation

sealed class Screens(val route: String) {
    object HomeScreen: Screens(route = "Home_Screen")
    object AuthScreen: Screens(route = "Auth_Screen")
}
