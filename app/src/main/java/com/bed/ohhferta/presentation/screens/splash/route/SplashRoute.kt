package com.bed.ohhferta.presentation.screens.splash.route

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import com.bed.ohhferta.presentation.screens.routes.Routes
import com.bed.ohhferta.presentation.screens.splash.SplashScreen

fun NavGraphBuilder.splashScreen() {
    composable(route = Routes.Splash.SCREEN) {
        SplashScreen()
    }
}
