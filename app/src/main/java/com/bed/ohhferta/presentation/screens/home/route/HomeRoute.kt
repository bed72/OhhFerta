package com.bed.ohhferta.presentation.screens.home.route

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bed.ohhferta.presentation.screens.home.HomeScreen

import com.bed.ohhferta.presentation.screens.routes.Routes

fun NavGraphBuilder.offersScreen() {
    composable(route = Routes.Home.OFFERS_SCREEN) {
        HomeScreen()
    }
}
