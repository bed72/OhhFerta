package com.bed.ohhferta.presentation.screens.home

import androidx.compose.runtime.Composable

import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme

import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize

import com.bed.ohhferta.presentation.themes.OhhFertaTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    GreetingWidget("Android", modifier)
}

@Composable
fun GreetingWidget(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize().wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Bed $name",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingWidgetPreview() {
    OhhFertaTheme {
        HomeScreen()
    }
}
