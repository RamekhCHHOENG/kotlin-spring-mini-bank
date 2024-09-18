package com.mini.bank.backend.dto.authentication

data class AuthenticationRequest(
    val username: String,
    val password: String,
)
