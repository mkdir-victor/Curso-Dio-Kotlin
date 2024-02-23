package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.service.ICustmerService
import me.dio.creditapplicationsystem.entity.Custmer
import me.dio.creditapplicationsystem.repository.CustmerRepository
import org.springframework.stereotype.Service

@Service
class CustmerService(
    private val custmerRepository: CustmerRepository
):ICustmerService {

    override fun save(custmer: Custmer): Custmer = this.custmerRepository.save(custmer)


    override fun findById(id: Long) = this.custmerRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
    }

    override fun delate(id: Long) = this.custmerRepository.deleteById(id)

}
