package com.bed.ohhferta.presentation.screens.home

import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.bed.ohhferta.presentation.themes.OhhFertaTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    GreetingWidget("Android", modifier)
}

@Composable
fun GreetingWidget(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Bed $name",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingWidgetPreview() {
    OhhFertaTheme {
        HomeScreen()
    }
}
