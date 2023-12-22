package com.bed.ohhferta.framework.modules.mappers

import com.google.firebase.auth.FirebaseUser

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.bed.ohhferta.framework.network.mappers.NetworkMapper
import com.bed.ohhferta.framework.network.mappers.MessageNetworkMapper
import com.bed.ohhferta.framework.network.mappers.AuthenticationNetworkMapper

import com.bed.ohhferta.framework.network.responses.message.MessageResponse
import com.bed.ohhferta.framework.network.responses.authentication.AuthenticationResponse

@Module
@InstallIn(SingletonComponent::class)
interface MappersModule {
    @Binds
    fun bindMessageMapper(mapper: MessageNetworkMapper): NetworkMapper<String?, MessageResponse>

    @Binds
    fun bindAuthenticationMapper(
        mapper: AuthenticationNetworkMapper
    ): NetworkMapper<FirebaseUser, AuthenticationResponse>
}
