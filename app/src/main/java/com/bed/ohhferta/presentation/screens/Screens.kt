package com.bed.ohhferta.presentation.screens

sealed class Screens(val route: String, val nested: String) {
    data object Home : Screens("home_screen_route", "home_nested_screen_route")
}
