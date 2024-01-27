package com.bed.ohhferta.presentation.screens.favorites

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import com.bed.ohhferta.presentation.commons.routes.RootRoutes

fun NavGraphBuilder.favoritesScreen() {
    composable(route = RootRoutes.Home.FAVORITES_SCREEN) {
        FavoritesScreen()
    }
}
