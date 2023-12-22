package com.bed.ohhferta.framework.network.responses.message

import com.bed.core.domain.models.failure.MessageModel

data class MessageResponse(val message: String?)

fun MessageResponse.toModel() = MessageModel(message ?: "Ops credenciais inválidas.")
