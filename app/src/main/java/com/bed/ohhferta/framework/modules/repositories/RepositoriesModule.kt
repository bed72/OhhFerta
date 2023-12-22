package com.bed.ohhferta.framework.modules.repositories

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.bed.core.data.repositories.AuthenticationRepository
import com.bed.core.data.repositories.AuthenticationRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {
    @Binds
    fun bindAuthenticationRepository(repository: AuthenticationRepositoryImpl): AuthenticationRepository
}
