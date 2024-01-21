package com.bed.core.domain.models.offers

import java.time.LocalDate

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
    "http://10.0.2.2:8090/api/files/$collectionName/$id/${images.first()}?thumb=0x300"
