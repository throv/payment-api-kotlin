package com.project.payment

import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@RestController
@RequestMapping("/payments")
class PaymentController {

    val paymentList: MutableList<Payment> = mutableListOf(Payment(1, 100.5, "USD", "CREDIT_CARD", "Payment for purchase XWOZ", "PENDING", LocalDateTime.now()))

    @GetMapping("/{id}")
    fun getPaymentById(@PathVariable id: Int): Payment? = paymentList.firstOrNull() { it.id == id }

    @PostMapping
    fun createPayment(@RequestBody request: CreatePayment): Payment {

        var id = 2
        val newPayment = Payment(id++, request.amount, request.currency, request.paymentMethod, request.description, "PENDING", LocalDateTime.now())

        paymentList.add(newPayment)

       return newPayment

    }

}