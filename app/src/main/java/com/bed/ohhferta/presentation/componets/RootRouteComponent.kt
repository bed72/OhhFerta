package com.bed.ohhferta.presentation.componets

import androidx.annotation.StringRes
import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource

import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.graphics.vector.ImageVector

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

import androidx.navigation.navigation
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

import com.bed.ohhferta.R

import com.bed.ohhferta.presentation.commons.routes.RootRoutes

import com.bed.ohhferta.presentation.screens.offers.offersScreen
import com.bed.ohhferta.presentation.screens.stores.storesScreen
import com.bed.ohhferta.presentation.screens.favorites.favoritesScreen

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun RootRouteComponent(navController: NavHostController, startDestination: String) {
    Scaffold(
        bottomBar = {
            BottomNavigationBarComponent(
                navController = navController
            )
        }
    ) {
        NavHost(navController = navController, startDestination = startDestination) {
            navigation(
                route = RootRoutes.Home.GRAPH,
                startDestination = RootRoutes.Home.OFFERS_SCREEN
            ) {
                offersScreen()
                storesScreen()
                favoritesScreen()
            }
        }
    }
}

sealed class Screen(val route: String, val icon: ImageVector, @StringRes val label: Int) {
    data object Offers :
        Screen(RootRoutes.Home.OFFERS_SCREEN, Icons.Default.Campaign, R.string.offers_title_tab)
    data object Stores :
        Screen(RootRoutes.Home.STORES_SCREEN, Icons.Default.Storefront, R.string.stores_title_tab)
    data object Favorites :
        Screen(RootRoutes.Home.FAVORITES_SCREEN, Icons.Default.Favorite, R.string.favorites_title_tab)
}

@Composable
fun BottomNavigationBarComponent(navController: NavController) {
    val items = listOf(Screen.Offers, Screen.Stores, Screen.Favorites)

    BottomNavigation(
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                label = { Text(text = stringResource(screen.label)) },
                icon = { Icon(screen.icon, contentDescription = null) },
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}
