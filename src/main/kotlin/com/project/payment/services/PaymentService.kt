package com.project.payment.services

import com.project.payment.dto.PaymentDto
import com.project.payment.enums.Status
import com.project.payment.model.PaymentModel
import com.project.payment.repository.PaymentRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class PaymentService(private val paymentRepository: PaymentRepository) {

    fun createPayment(newPayment: PaymentDto) : PaymentModel  {

        val payment = PaymentModel(
            id = UUID.randomUUID(),
            amount = newPayment.amount,
            currency = newPayment.currency,
            paymentMethod = newPayment.paymentMethod,
            description = newPayment.description,
            status = Status.PENDING,
            createdAt = LocalDateTime.now()
        )

        return paymentRepository.save(payment)
    }

    fun getPaymentById(id: UUID) : ResponseEntity<Any> {

        val payment = paymentRepository.findById(id)

        return if(payment.isPresent) {
            ResponseEntity.ok(payment)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("No payments found!")
        }
    }
}