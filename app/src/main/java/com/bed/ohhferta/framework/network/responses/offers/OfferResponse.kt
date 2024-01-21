package com.bed.ohhferta.framework.network.responses.offers

import java.time.LocalDate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.bed.core.domain.models.offers.OfferModel

@Serializable
data class OfferResponse(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String,

    @SerialName("price")
    val price: Float,

    @SerialName("store")
    val store: String,

    @SerialName("description")
    val description: String,

    @SerialName("collectionName")
    val collectionName: String,

    @SerialName("validate")
    val validate: String,

    @SerialName("images")
    val images: List<String>,

    @SerialName("categories")
    val categories: List<String>,
)

fun OfferResponse.toModel() = OfferModel(
    id,
    name,
    price,
    store,
    description,
    collectionName,
    validate = LocalDate.now(),
    images,
    categories
)
