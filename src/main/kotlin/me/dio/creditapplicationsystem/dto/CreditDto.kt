package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Custmer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "invalid input") val creditValue: BigDecimal,
    @field:Future(message = "") val dayFirstOfInstallment: LocalDate,
    val numberOfInstallment: Int,
    @field:NotNull(message = "invalid input") val custmerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstalment = this.dayFirstOfInstallment,
        numberOfInsttalment = this.numberOfInstallment,
        custmer = Custmer(id = this.custmerId)
    )

}
