package com.bed.ohhferta.framework.modules.usecases

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.factoryOf

import com.bed.core.usecases.coroutines.CoroutinesUseCase
import com.bed.core.usecases.coroutines.CoroutinesUseCaseImpl

import com.bed.core.usecases.authentication.GetAllOffersUseCase
import com.bed.core.usecases.authentication.GetAllOffersUseCaseImpl

val useCasesModule = module {
    factoryOf(::GetAllOffersUseCaseImpl) bind GetAllOffersUseCase::class
    singleOf(::CoroutinesUseCaseImpl) bind CoroutinesUseCase::class
}
