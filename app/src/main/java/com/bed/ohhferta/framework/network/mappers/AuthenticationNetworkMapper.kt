package com.bed.ohhferta.framework.network.mappers

import javax.inject.Inject

import com.google.firebase.auth.FirebaseUser

import com.bed.ohhferta.framework.network.responses.authentication.AuthenticationResponse

class AuthenticationNetworkMapper @Inject constructor() : NetworkMapper<FirebaseUser, AuthenticationResponse> {
    override fun invoke(data: FirebaseUser) = AuthenticationResponse(
        uid = data.uid,
        name = data.displayName,
        email = data.email,
        photo = data.photoUrl.toString(),
        emailVerified = data.isEmailVerified
    )
}
