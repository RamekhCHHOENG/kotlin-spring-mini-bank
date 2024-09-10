package com.mini.bank.backend.model.branch

import jakarta.persistence.*

@Entity
@Table(name = "branches")
data class Branch(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val branchId: Long,

    @Column(nullable = false)
    val branchName: String,

    @Column(nullable = false)
    val branchCode: String,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false)
    val phoneNumber: String
)