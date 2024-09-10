package com.mini.bank.backend.model.transaction

import com.mini.bank.backend.model.account.Account
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "transactions")
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val transactionId: Long,

    @Column(nullable = false)
    val transactionType: String,

    @Column(nullable = false)
    val amount: Double,

    @Column(nullable = false)
    val transactionDate: Date,

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    val account: Account
)