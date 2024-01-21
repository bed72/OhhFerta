package com.bed.ohhferta.presentation.screens.routes

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController

import com.bed.ohhferta.presentation.screens.home.homeGraph

@Composable
fun RouteWidget(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        homeGraph()
    }
}

class Routes {
    object Home {
        const val GRAPH = "home_graph"
        const val OFFERS_SCREEN = "offers_screen"
    }
}
