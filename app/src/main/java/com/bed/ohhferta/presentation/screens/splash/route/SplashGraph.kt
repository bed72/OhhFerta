package com.bed.ohhferta.presentation.screens.splash.route

import androidx.navigation.navigation
import androidx.navigation.NavGraphBuilder

import com.bed.ohhferta.presentation.screens.routes.Routes

fun NavGraphBuilder.splashGraph() {
    navigation(
        route = Routes.Splash.GRAPH,
        startDestination = Routes.Splash.SCREEN
    ) {
        splashScreen()
    }
}
