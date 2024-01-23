package com.bed.core.domain.models.offers

import java.time.LocalDate

import com.bed.core.domain.models.paths.PathModel

data class OfferModel(
    val id: String,
    val name: String,
    val price: Float,
    val store: String,
    val description: String,
    val collectionName: String,
    val validate: LocalDate,
    val images: List<String>,
    val categories: List<String>,
)

fun OfferModel.getThumb() =
    "${PathModel.API.value}/files/$collectionName/$id/${images.first()}?thumb=0x300"
