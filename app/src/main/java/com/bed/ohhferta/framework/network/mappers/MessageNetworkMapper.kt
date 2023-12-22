package com.bed.ohhferta.framework.network.mappers

import javax.inject.Inject

import com.bed.ohhferta.framework.network.responses.message.MessageResponse

class MessageNetworkMapper @Inject constructor() : NetworkMapper<String?, MessageResponse> {
    override fun invoke(data: String?) = MessageResponse(data)
}
