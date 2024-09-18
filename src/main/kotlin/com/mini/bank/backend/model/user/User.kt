package com.mini.bank.backend.model.user

import com.mini.bank.backend.enums.Gender
import com.mini.bank.backend.enums.RoleType
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val dateOfBirth: Date,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val phoneNumber: String,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false)
    val taxIdentifier: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val gender: Gender,

    @Column(nullable = false, unique = true)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val role: RoleType
)