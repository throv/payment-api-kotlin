package com.project.payment.model

import com.project.payment.enums.Status
import jakarta.persistence.*

import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "payments")
data class PaymentModel(

    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val amount: Double = 0.0,
    val currency: String = "",
    val paymentMethod: String = "",
    val description: String = "",
    @Enumerated(EnumType.STRING)
    val status: Status = Status.PENDING,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
