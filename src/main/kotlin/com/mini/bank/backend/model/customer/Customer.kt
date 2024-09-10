package com.mini.bank.backend.model

import com.mini.bank.backend.model.person.Person
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
    @JoinColumn(name = "person_id", referencedColumnName = "personId")
    val person: Person
)
