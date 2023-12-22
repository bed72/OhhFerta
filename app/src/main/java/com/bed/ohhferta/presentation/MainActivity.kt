package com.bed.ohhferta.presentation

import android.os.Bundle

import dagger.hilt.android.AndroidEntryPoint

import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.navigationBarsPadding

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.bed.ohhferta.presentation.themes.OhhFertaTheme

import com.bed.ohhferta.presentation.screens.routes.Routes
import com.bed.ohhferta.presentation.screens.routes.RouteWidget

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(Color.Transparent.hashCode(), Color.Transparent.hashCode()),
            navigationBarStyle = SystemBarStyle.auto(Color.Transparent.hashCode(), Color.Transparent.hashCode())
        )

        setContent {
            OhhFertaTheme {
                val navController = rememberNavController()

                MainWidget(navController = navController)
            }
        }
    }


    @Composable
    private fun MainWidget(
        modifier: Modifier = Modifier,
        navController: NavHostController,
        viewModel: MainViewModel = viewModel()
    ) {
        val state by viewModel.state.collectAsState()
        val isLogged = state is MainViewModel.States.IsLoggedIn && (state as MainViewModel.States.IsLoggedIn).isLogged

        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = modifier
                .statusBarsPadding()
                .navigationBarsPadding()
                .background(MaterialTheme.colorScheme.background)
        ) {
            RouteWidget(
                navController = navController,
                startDestination = if (isLogged) Routes.Home.GRAPH else Routes.Authentication.GRAPH
            )
        }
    }
}
