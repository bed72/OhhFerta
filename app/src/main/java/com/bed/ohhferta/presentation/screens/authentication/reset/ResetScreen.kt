package com.bed.ohhferta.presentation.screens.authentication.reset

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
fun ResetScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize().wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Reset",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingWidgetPreview() {
    OhhFertaTheme {
        ResetScreen()
    }
}
