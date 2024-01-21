package com.bed.ohhferta.framework.modules.clients

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import com.bed.ohhferta.framework.network.clients.HttpClient
import com.bed.ohhferta.framework.network.clients.HttpClientImpl

fun clientsModule() = module {
    singleOf(::HttpClientImpl) bind HttpClient::class
}
