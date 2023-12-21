package com.bed.ohhferta.presentation

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.fillMaxSize

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.bed.ohhferta.presentation.navigation.NavigationWidget
import com.bed.ohhferta.presentation.navigation.home.HomeRoutes

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            val navController = rememberNavController()

            MainWidget(navController = navController)
        }
    }

    @Composable
    private fun MainWidget(navController: NavHostController, modifier: Modifier = Modifier) {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
        ) {
            NavigationWidget(
                navController = navController,
                startDestination = HomeRoutes.HOME_GRAPH
            )
        }
    }
}
