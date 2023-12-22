package com.bed.ohhferta.presentation.screens.home

import androidx.navigation.navigation
import androidx.navigation.NavGraphBuilder

import com.bed.ohhferta.presentation.screens.routes.Routes
import com.bed.ohhferta.presentation.screens.home.offers.offersScreen

fun NavGraphBuilder.homeGraph() {
    navigation(
        route = Routes.Home.GRAPH,
        startDestination = Routes.Home.OFFERS_SCREEN
    ) {
        offersScreen()
    }
}
