package com.mini.bank.backend.model.person


import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "persons")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val personId: Long,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val dateOfBirth: Date,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val phoneNumber: String,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false)
    val taxIdentifier: String
)