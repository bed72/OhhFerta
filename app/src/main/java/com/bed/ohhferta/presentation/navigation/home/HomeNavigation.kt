package com.bed.ohhferta.presentation.navigation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import com.bed.ohhferta.presentation.screens.home.HomeScreen

fun NavGraphBuilder.offersScreen() {
    composable(route = HomeRoutes.HOME_OFFERS_SCREEN) {
        HomeScreen()
    }
}
