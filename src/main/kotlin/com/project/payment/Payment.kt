package com.project.payment

import java.time.LocalDateTime

data class Payment (
    val id: Int,
    val amount: Double,
    val currency: String,
    val paymentMethod: String,
    val description: String,
    val status: String,
    val createdAt: LocalDateTime
)

data class CreatePayment (
    val amount: Double,
    val currency: String,
    val paymentMethod: String,
    val description: String,
)