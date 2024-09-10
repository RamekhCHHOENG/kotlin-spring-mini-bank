package com.mini.bank.backend.model.loanPayment

import com.mini.bank.backend.model.loan.Loan
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "loan_payments")
data class LoanPayment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val loanPaymentId: Long,

    @Column(nullable = false)
    val scheduledPaymentDate: Date,

    @Column(nullable = false)
    val paymentAmount: Double,

    @Column(nullable = false)
    val principalAmount: Double,

    @Column(nullable = false)
    val interestAmount: Double,

    @Column(nullable = false)
    val paidAmount: Double,

    val paidDate: Date?,

    @ManyToOne
    @JoinColumn(name = "loan_id", referencedColumnName = "loanId")
    val loan: Loan
)