package com.project.payment

import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@RestController
@RequestMapping("/payments")
class PaymentController {

    private val paymentList: MutableList<Payment> = mutableListOf(Payment(1, 100.5, "USD", "CREDIT_CARD", "Payment for purchase XWOZ", "PENDING", LocalDateTime.now()))
    var newId = 2

    @GetMapping("/{id}")
    fun getPaymentById(@PathVariable id: Int): Payment? = paymentList.firstOrNull() { it.id == id }

    @PostMapping
    fun createPayment(@RequestBody request: CreatePayment): Payment {

        val newPayment = Payment(newId++, request.amount, request.currency, request.paymentMethod, request.description, "PENDING", LocalDateTime.now())

        paymentList.add(newPayment)

       return newPayment

    }
}