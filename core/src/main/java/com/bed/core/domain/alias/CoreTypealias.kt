package com.bed.core.domain.alias

import arrow.core.Either

import com.bed.core.domain.models.offers.OfferModel
import com.bed.core.domain.models.exceptions.ClientExceptionModel

typealias OffersType = Either<ClientExceptionModel, List<OfferModel>>
