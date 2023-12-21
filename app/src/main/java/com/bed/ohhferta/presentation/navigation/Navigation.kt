package com.bed.ohhferta.presentation.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController

import com.bed.ohhferta.presentation.navigation.home.homeGraph

@Composable
fun NavigationWidget(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        homeGraph()
    }
}
