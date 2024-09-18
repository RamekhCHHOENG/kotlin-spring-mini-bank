package com.mini.bank.backend.dto.authentication

data class AuthenticationResponse(
    val accessToken: String,
    val refreshToken: String,
)
