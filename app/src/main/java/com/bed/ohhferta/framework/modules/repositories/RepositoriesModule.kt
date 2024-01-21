package com.bed.ohhferta.framework.modules.repositories

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import com.bed.core.repositories.OffersRepository

import com.bed.ohhferta.data.repositories.OffersRepositoryImpl

val repositoriesModule = module {
    factoryOf(::OffersRepositoryImpl) bind OffersRepository::class
}
