package com.mini.bank.backend.dto

import com.mini.bank.backend.enums.Gender

data class CreateUserRequest(
    val lastName: String,
    val firstName: String,
    val dateOfBirth: String,
    val email: String,
    val phoneNumber: String,
    val address: String,
    val taxIdentifier: String,
    val gender: Gender
)

data class UpdateUserRequest(
    val lastName: String?,
    val firstName: String?,
    val dateOfBirth: String?,
    val email: String?,
    val phoneNumber: String?,
    val address: String?,
    val taxIdentifier: String?,
    val gender: Gender?
)

data class UserResponse(
    val id: Long,
    val lastName: String,
    val firstName: String,
    val dateOfBirth: String,
    val email: String,
    val phoneNumber: String,
    val address: String,
    val taxIdentifier: String,
    val gender: Gender
)