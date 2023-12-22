package com.bed.ohhferta.presentation

import android.os.Bundle

import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.bed.ohhferta.presentation.themes.OhhFertaTheme
import com.bed.ohhferta.presentation.screens.routes.Routes
import com.bed.ohhferta.presentation.screens.routes.NavigationWidget

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(Color.Transparent.hashCode(), Color.Transparent.hashCode()),
            navigationBarStyle = SystemBarStyle.auto(Color.Transparent.hashCode(), Color.Transparent.hashCode())
        )

        setContent {
            OhhFertaTheme {
                val navController = rememberNavController()

                MainWidget(navController = navController)
            }
        }
    }

    @Composable
    private fun MainWidget(navController: NavHostController, modifier: Modifier = Modifier) {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = modifier
                .statusBarsPadding()
                .navigationBarsPadding()
                .background(MaterialTheme.colorScheme.background)
        ) {
            NavigationWidget(
                navController = navController,
                startDestination = Routes.Splash.GRAPH
            )
        }
    }
}
