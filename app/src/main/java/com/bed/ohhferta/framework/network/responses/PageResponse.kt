package com.bed.ohhferta.framework.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageResponse<out T>(
    @SerialName("page")
    val page: Int,

    @SerialName("perPage")
    val perPage: Int,

    @SerialName("totalItems")
    val totalItems: Int,

    @SerialName("totalPages")
    val totalPages: Int,

    @SerialName("items")
    val items: List<T>
)
