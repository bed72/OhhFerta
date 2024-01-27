package com.bed.ohhferta.presentation.screens.favorites

import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

@Composable
fun FavoritesScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Favorites", modifier = Modifier.align(Alignment.Center))
    }
}
