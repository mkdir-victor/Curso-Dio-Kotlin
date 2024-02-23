package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.enumeration.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode: UUID,
    val creditValue:BigDecimal,
    val numberOfInstallment:Int,
    val status:Status,
    val emailCustmer:String?,
    val incomeCustmer:BigDecimal?
) {

    constructor(credit:Credit):this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInsttalment,
        status = credit.status,
        emailCustmer = credit.custmer?.email,
        incomeCustmer = credit.custmer?.income
    )

}
