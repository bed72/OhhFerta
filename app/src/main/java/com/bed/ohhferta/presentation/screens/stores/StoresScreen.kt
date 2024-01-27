package com.bed.ohhferta.presentation.screens.stores

import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

@Composable
fun StoresScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Stores", modifier = Modifier.align(Alignment.Center))
    }
}
