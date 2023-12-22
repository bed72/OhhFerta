package com.bed.ohhferta.presentation.screens.routes

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController

import com.bed.ohhferta.presentation.screens.home.route.homeGraph
import com.bed.ohhferta.presentation.screens.splash.route.splashGraph

@Composable
fun NavigationWidget(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        splashGraph()
        homeGraph()
    }
}

class Routes {
    object Splash {
        const val GRAPH = "splash_graph"
        const val SCREEN = "splash_screen"
    }

    object Home {
        const val GRAPH = "home_graph"
        const val OFFERS_SCREEN = "offers_screen"
    }
}
