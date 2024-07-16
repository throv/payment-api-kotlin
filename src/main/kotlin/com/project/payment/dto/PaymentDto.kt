package com.project.payment.dto

data class PaymentDto(

    val amount: Double,
    val currency: String,
    val paymentMethod: String,
    val description: String,
)
