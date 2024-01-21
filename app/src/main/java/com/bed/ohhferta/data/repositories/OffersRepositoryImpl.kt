package com.bed.ohhferta.data.repositories

import com.bed.core.domain.alias.OffersType

import com.bed.core.repositories.OffersRepository

import com.bed.ohhferta.framework.network.responses.offers.toModel
import com.bed.ohhferta.framework.network.responses.exceptions.toModel

import com.bed.ohhferta.data.datasources.remote.RemoteOffersDataSource

class OffersRepositoryImpl(private val dataSource: RemoteOffersDataSource) : OffersRepository {
    override suspend fun getAll(vararg parameters: Pair<String, Any>?): OffersType {
        val response = dataSource.getAll(*parameters)

        return response
            .mapLeft { failure -> failure.toModel() }
            .map { success -> success.items.map { it.toModel() } }
    }
}
