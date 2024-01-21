package com.bed.ohhferta.framework.network.responses.exceptions

import com.bed.core.domain.models.exceptions.ClientExceptionModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientExceptionResponse(
    @SerialName("code")
    val code: Int,

    @SerialName("message")
    val message: String
)

fun ClientExceptionResponse.toModel() = ClientExceptionModel(code, message)
