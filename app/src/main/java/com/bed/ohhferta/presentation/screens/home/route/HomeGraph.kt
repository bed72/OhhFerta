package com.bed.ohhferta.presentation.screens.home.route

import androidx.navigation.navigation
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

import com.bed.ohhferta.presentation.screens.routes.Routes

fun NavGraphBuilder.homeGraph() {
    navigation(
        route = Routes.Home.GRAPH,
        startDestination = Routes.Home.OFFERS_SCREEN
    ) {
        offersScreen()
    }
}

fun NavHostController.navigateToHomeGraph() {
    navigate(Routes.Home.GRAPH)
}
