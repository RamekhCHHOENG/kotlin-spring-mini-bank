package com.mini.bank.backend.model.loan

import com.mini.bank.backend.model.Customer
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "loans")
data class Loan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val loanId: Long,

    @Column(nullable = false)
    val loanType: String,

    @Column(nullable = false)
    val loanAmount: Double,

    @Column(nullable = false)
    val interestRate: Double,

    @Column(nullable = false)
    val term: Int,

    @Column(nullable = false)
    val startDate: Date,

    val endDate: Date?,

    @Column(nullable = false)
    val loanStatus: String,

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    val customer: Customer
)