package com.mini.bank.backend.controller.auth

data class AuthenticationRequest(
    val username: String,
    val password: String,
)
