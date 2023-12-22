package com.bed.ohhferta.presentation.screens.authentication.signin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import com.bed.ohhferta.presentation.screens.routes.Routes

fun NavGraphBuilder.signInRoute() {
    composable(route = Routes.Authentication.SIGN_IN_SCREEN) {
        SigInScreen()
    }
}
