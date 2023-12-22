package com.bed.ohhferta.framework.modules.datasources

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.bed.core.data.datasources.remote.RemoteAuthenticationDatasource
import com.bed.ohhferta.datasources.remote.RemoteAuthenticationDatasourceImpl

@Module
@InstallIn(SingletonComponent::class)
interface DatasourcesModule {
    @Binds
    fun bindAuthenticationDatasource(
        datasource: RemoteAuthenticationDatasourceImpl
    ): RemoteAuthenticationDatasource
}
