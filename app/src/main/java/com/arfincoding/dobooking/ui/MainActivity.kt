package com.arfincoding.dobooking.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.arfincoding.dobooking.navigation.NavigationGraph
import com.arfincoding.dobooking.ui.theme.JWTAuthKtorAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            JWTAuthKtorAndroidTheme {
                NavigationGraph()
            }
        }
    }
}