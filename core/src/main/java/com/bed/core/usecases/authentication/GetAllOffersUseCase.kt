package com.bed.core.usecases.authentication

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

import com.bed.core.domain.alias.OffersType

import com.bed.core.repositories.OffersRepository

import com.bed.core.usecases.UseCaseWithoutParameter
import com.bed.core.usecases.coroutines.CoroutinesUseCase

interface GetAllOffersUseCase {
    operator fun invoke(): Flow<OffersType>
}

class GetAllOffersUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: OffersRepository,
) : GetAllOffersUseCase, UseCaseWithoutParameter<OffersType>() {
    override suspend fun doWork(): OffersType =
        withContext(useCase.io()) { repository.getAll(null) }
}
