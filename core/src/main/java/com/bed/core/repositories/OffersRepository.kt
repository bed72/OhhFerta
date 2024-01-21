package com.bed.core.repositories

import com.bed.core.domain.alias.OffersType

interface OffersRepository {
    suspend fun getAll(vararg parameters: Pair<String, Any>?): OffersType
}
