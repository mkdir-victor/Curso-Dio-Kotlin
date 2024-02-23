package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.Credit
import java.util.*

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustmer(custmerId: Long):List<Credit>
    fun findByCreditCode(creditCode: UUID,custmerId: Long): Credit
}