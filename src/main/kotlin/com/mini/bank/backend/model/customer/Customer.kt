package com.mini.bank.backend.model

import com.mini.bank.backend.model.user.User
import jakarta.persistence.*

@Entity
@Table(name = "customers")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val customerId: Long,

    @Column(nullable = false)
    val customerType: String,

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    val person: User
)
