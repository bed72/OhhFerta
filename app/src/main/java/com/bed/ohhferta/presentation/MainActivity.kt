package com.bed.ohhferta.presentation

import android.os.Bundle

import cafe.adriel.voyager.navigator.Navigator

import org.koin.androidx.viewmodel.ext.android.viewModel

import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.navigationBarsPadding

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.bed.ohhferta.presentation.screens.home.offers.OffersScreen
import com.bed.ohhferta.presentation.screens.home.offers.OffersViewModel

import com.bed.ohhferta.presentation.themes.OhhFertaTheme

class MainActivity : ComponentActivity() {

    private val viewModel: OffersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(Color.Transparent.hashCode(), Color.Transparent.hashCode()),
            navigationBarStyle = SystemBarStyle.auto(Color.Transparent.hashCode(), Color.Transparent.hashCode())
        )

        setContent {
            OhhFertaTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier
                        .statusBarsPadding()
                        .navigationBarsPadding()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Navigator(OffersScreen(viewModel))
                }
            }
        }
    }
}
