package com.mini.bank.backend.model.account

import com.mini.bank.backend.model.Customer
import com.mini.bank.backend.model.branch.Branch
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val accountId: Long,

    @Column(nullable = false)
    val accountNumber: String,

    @Column(nullable = false)
    val accountType: String,

    @Column(nullable = false)
    val currentBalance: Double,

    @Column(nullable = false)
    val dateOpened: Date,

    val dateClosed: Date?,

    @Column(nullable = false)
    val accountStatus: String,

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    val customer: Customer,

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "branchId")
    val branch: Branch
)