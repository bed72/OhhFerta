package com.bed.ohhferta.presentation.screens.home.offers

import coil.compose.rememberAsyncImagePainter

import cafe.adriel.voyager.core.screen.Screen


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
import androidx.compose.material3.ExperimentalMaterial3Api

import com.bed.ohhferta.R

import com.bed.core.domain.models.offers.getThumb
import com.bed.core.domain.models.offers.OfferModel

import com.bed.ohhferta.presentation.themes.OhhFertaTheme
import com.bed.ohhferta.presentation.commons.states.States
import de.charlex.compose.material3.HtmlText


class OffersScreen(private val viewModel: OffersViewModel) : Screen {
    @Composable
    override fun Content() {
        val state by viewModel.state.collectAsState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            when (state) {
                States.Initial, States.Loading -> IsLoading()
                is States.Failure -> IsFailure((state as States.Failure).data)
                is States.Success -> IsSuccessful((state as States.Success<List<OfferModel>>).data)
            }
        }
    }

    @Composable
    private fun IsLoading() {
        CircularProgressIndicator()
    }

    @Composable
    private fun IsFailure(message: String) {
        Text(
            text = message,
            style = MaterialTheme.typography.titleLarge
        )
    }

    @Composable
    private fun IsSuccessful(offers: List<OfferModel>) {
        LazyColumn(modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()) {
            items(
                items = offers,
                key = { it.id }
            ) { offer ->
                Card(offer = offer)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Card(offer: OfferModel) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Card {
                Column(modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxSize()) {
                    Image(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(128.dp)
                            .fillMaxWidth(),
                        painter = rememberAsyncImagePainter(model = offer.getThumb()),
                        contentDescription = stringResource(id = R.string.image_offer_description, offer.name)
                    )
                    Text(
                        text = offer.name,
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    HtmlText(
                        text = offer.description,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.bodyMedium,
                    )
//                    HtmlText(
//                        offer.description,
////                        maxLines = 8,
//                        overflow = TextOverflow.Ellipsis,
//                        style = MaterialTheme.typography.bodyMedium,
//                        modifier = Modifier.padding(horizontal = 8.dp)
//                    )
                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingWidgetPreview() {
    OhhFertaTheme {}
}
