package com.bed.ohhferta.presentation

import android.os.Bundle
import android.annotation.SuppressLint

import androidx.navigation.compose.rememberNavController

import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.ui.graphics.Color

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.bed.ohhferta.presentation.themes.OhhFertaTheme

import com.bed.ohhferta.presentation.themes.darkBackground
import com.bed.ohhferta.presentation.themes.lightBackground

import com.bed.ohhferta.presentation.commons.routes.RootRoutes
import com.bed.ohhferta.presentation.componets.RootRouteComponent

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.auto(lightBackground.hashCode(), darkBackground.hashCode()),
//            navigationBarStyle = SystemBarStyle.auto(lightBackground.hashCode(), darkBackground.hashCode())
//        )

        setContent {
            OhhFertaTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier
                        .statusBarsPadding()
                        .navigationBarsPadding()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    RootRouteComponent(
                        navController = rememberNavController(),
                        startDestination = RootRoutes.Home.GRAPH
                    )
                }
            }
        }
    }
}
