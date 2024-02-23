package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.service.ICreditService
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.repository.CreditRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val custmerService: CustmerService
):ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            custmer = custmerService.findById(credit.custmer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustmer(custmerId: Long): List<Credit> = this.creditRepository.findAllByCustmerId(custmerId)

    override fun findByCreditCode(creditCode: UUID,custmerId: Long): Credit {
        val credit:Credit =  this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Creditcode: $creditCode not found")
        return  if (credit.custmer?.id == custmerId) credit else throw RuntimeException("Contact Admin")
    }
}