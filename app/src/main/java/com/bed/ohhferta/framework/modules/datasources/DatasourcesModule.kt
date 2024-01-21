package com.bed.ohhferta.framework.modules.datasources

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import com.bed.ohhferta.data.datasources.remote.RemoteOffersDataSource
import com.bed.ohhferta.data.datasources.remote.RemoteOffersDataSourceImpl

val dataSourcesModule = module {
    factoryOf(::RemoteOffersDataSourceImpl) bind RemoteOffersDataSource::class
}
