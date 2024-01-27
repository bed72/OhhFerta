package com.bed.ohhferta.presentation.screens.offers

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import org.koin.androidx.compose.koinViewModel

import com.bed.ohhferta.presentation.commons.routes.RootRoutes

fun NavGraphBuilder.offersScreen() {
    composable(route = RootRoutes.Home.OFFERS_SCREEN) {
        OffersScreen(koinViewModel<OffersViewModel>())
    }
}
