package com.bed.ohhferta.presentation.screens.home.offers

import coil.compose.rememberAsyncImagePainter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentSize

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator

import com.bed.ohhferta.R

import com.bed.core.domain.models.offers.getThumb
import com.bed.core.domain.models.offers.OfferModel

import com.bed.ohhferta.presentation.themes.OhhFertaTheme
import com.bed.ohhferta.presentation.commons.states.States

@Composable
fun OffersScreen(
    viewModel: OffersViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        when (state) {
            States.Initial, States.Loading -> IsLoading(modifier)
            is States.Failure -> IsFailure(modifier, (state as States.Failure).data)
            is States.Success -> IsSuccessful(modifier, (state as States.Success<List<OfferModel>>).data)
        }
    }
}

@Composable
private fun IsLoading(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier)
}

@Composable
private fun IsFailure(modifier: Modifier = Modifier, message: String) {
    Text(
        text = message,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
private fun IsSuccessful(modifier: Modifier = Modifier, offers: List<OfferModel>) {
    LazyColumn(modifier = modifier
        .padding(16.dp)
        .fillMaxHeight()) {
        items(
            items = offers,
            key = { it.id }
        ) { offer ->
            Card(
                modifier = modifier,
                offer = offer
            )
        }
    }
}

@Composable
private fun Card(modifier: Modifier = Modifier, offer: OfferModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = modifier,
            // shape = CutCornerShape(20.dp)
            //border = BorderStroke(3.dp,Color.Gray)

        ) {
            Column(modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxSize()) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(128.dp).fillMaxWidth(),
                    painter = rememberAsyncImagePainter(model = offer.getThumb()),
                    contentDescription = stringResource(id = R.string.image_offer_description, offer.name)
                )
                Text(
                    text = offer.name,
                    modifier = modifier.padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    maxLines = 4,
                    text = offer.description,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(horizontal = 8.dp)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingWidgetPreview() {
    OhhFertaTheme {}
}
