package com.bed.ohhferta.presentation.navigation.home

import androidx.navigation.navigation
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.homeGraph() {
    navigation(
        route = HomeRoutes.HOME_GRAPH,
        startDestination = HomeRoutes.HOME_OFFERS_SCREEN
    ) {
        offersScreen()
    }
}

fun NavHostController.navigateToHomeGraph() {
    navigate(HomeRoutes.HOME_GRAPH)
}
