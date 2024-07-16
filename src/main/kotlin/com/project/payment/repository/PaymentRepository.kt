package com.project.payment.repository

import com.project.payment.model.PaymentModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PaymentRepository : JpaRepository<PaymentModel, UUID> {

}