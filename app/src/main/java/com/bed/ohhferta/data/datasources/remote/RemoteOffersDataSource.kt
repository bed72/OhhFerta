package com.bed.ohhferta.data.datasources.remote

import io.ktor.http.HttpMethod
import io.ktor.client.request.url
import io.ktor.client.request.parameter

import com.bed.ohhferta.data.datasources.alias.RemoteOffersType

import com.bed.ohhferta.framework.network.Paths
import com.bed.ohhferta.framework.network.clients.request
import com.bed.ohhferta.framework.network.clients.HttpClient

import com.bed.ohhferta.framework.network.responses.PageResponse
import com.bed.ohhferta.framework.network.responses.offers.OfferResponse
import com.bed.ohhferta.framework.network.responses.exceptions.ClientExceptionResponse

interface RemoteOffersDataSource {
    suspend fun getAll(vararg parameters: Pair<String, Any>?): RemoteOffersType
}

class RemoteOffersDataSourceImpl(private val client: HttpClient) : RemoteOffersDataSource {
    override suspend fun getAll(vararg parameters: Pair<String, Any>?): RemoteOffersType =
        client.http.request<ClientExceptionResponse, PageResponse<OfferResponse>> {
            method = HttpMethod.Get
            url(Paths.OFFERS.value)
            parameters.forEach {
                if (it != null) parameter(it.first, it.second)
            }

        }
}
