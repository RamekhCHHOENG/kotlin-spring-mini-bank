package com.mini.bank.backend.model.employee

import com.mini.bank.backend.model.person.Person
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
    @JoinColumn(name = "person_id", referencedColumnName = "personId")
    val person: Person
)
