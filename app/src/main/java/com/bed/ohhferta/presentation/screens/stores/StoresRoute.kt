package com.bed.ohhferta.presentation.screens.stores

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import com.bed.ohhferta.presentation.commons.routes.RootRoutes

fun NavGraphBuilder.storesScreen() {
    composable(route = RootRoutes.Home.STORES_SCREEN) {
        StoresScreen()
    }
}
