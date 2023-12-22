package com.bed.ohhferta.presentation.screens.routes

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController

import com.bed.ohhferta.presentation.screens.home.homeGraph
import com.bed.ohhferta.presentation.screens.authentication.authenticationGraph

@Composable
fun RouteWidget(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        homeGraph()
        authenticationGraph()
    }
}

class Routes {
    object Authentication {
        const val GRAPH = "authentication_graph"
        const val SIGN_IN_SCREEN = "sign_in_screen"
    }
    object Home {
        const val GRAPH = "home_graph"
        const val OFFERS_SCREEN = "offers_screen"
    }
}
