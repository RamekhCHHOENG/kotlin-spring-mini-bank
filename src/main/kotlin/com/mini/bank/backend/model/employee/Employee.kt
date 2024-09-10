package com.mini.bank.backend.model.employee

import com.mini.bank.backend.model.user.User
import jakarta.persistence.*

@Entity
@Table(name = "employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val employeeId: Long,

    @Column(nullable = false)
    val position: String,

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    val person: User
)
