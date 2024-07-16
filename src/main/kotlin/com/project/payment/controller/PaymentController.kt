package com.project.payment.controller

import com.project.payment.dto.PaymentDto
import com.project.payment.model.PaymentModel
import com.project.payment.services.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/payments")
class PaymentController(private val paymentService: PaymentService) {

    @GetMapping("/{id}")
    fun getPaymentById(@PathVariable id: UUID) : ResponseEntity<Any> {

        val payment = paymentService.getPaymentById(id)
        return payment
    }

    @PostMapping("/add")
    fun createPayment(@RequestBody paymentBody: PaymentDto): ResponseEntity<PaymentModel> {

        val newPayment = paymentService.createPayment(paymentBody)
        return ResponseEntity(newPayment, HttpStatus.CREATED)

    }
}