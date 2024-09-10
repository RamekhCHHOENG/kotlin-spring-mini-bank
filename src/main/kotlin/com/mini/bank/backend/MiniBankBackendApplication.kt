package com.mini.bank.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication class MiniBankBackendApplication

fun main(args: Array<String>) {
    runApplication<MiniBankBackendApplication>(*args)
}
