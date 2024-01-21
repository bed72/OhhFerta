package com.bed.ohhferta.data.datasources.alias

import arrow.core.Either

import com.bed.ohhferta.framework.network.responses.PageResponse
import com.bed.ohhferta.framework.network.responses.offers.OfferResponse
import com.bed.ohhferta.framework.network.responses.exceptions.ClientExceptionResponse

typealias RemoteOffersType = Either<ClientExceptionResponse, PageResponse<OfferResponse>>
