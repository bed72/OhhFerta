package com.bed.ohhferta.presentation.screens.authentication

import androidx.navigation.navigation
import androidx.navigation.NavGraphBuilder

import com.bed.ohhferta.presentation.screens.routes.Routes
import com.bed.ohhferta.presentation.screens.authentication.signin.signInRoute

fun NavGraphBuilder.authenticationGraph() {
    navigation(
        route = Routes.Authentication.GRAPH,
        startDestination = Routes.Authentication.SIGN_IN_SCREEN
    ) {
        signInRoute()
    }
}
