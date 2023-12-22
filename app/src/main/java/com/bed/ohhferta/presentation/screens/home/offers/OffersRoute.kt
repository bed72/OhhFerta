package com.bed.ohhferta.presentation.screens.home.offers

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import com.bed.ohhferta.presentation.screens.routes.Routes

fun NavGraphBuilder.offersScreen() {
    composable(route = Routes.Home.OFFERS_SCREEN) {
        OffersScreen()
    }
}
