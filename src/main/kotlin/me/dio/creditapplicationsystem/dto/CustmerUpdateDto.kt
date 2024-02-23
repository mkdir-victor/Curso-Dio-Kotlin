package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Custmer
import java.math.BigDecimal

data class CustmerUpdateDto(
    @field:NotEmpty(message = "invalid input") val firstName: String,
    @field:NotEmpty(message = "invalid input") val lastName: String,
    @field:NotNull(message = "invalid input") val income: BigDecimal,
    @field:NotEmpty(message = "invalid input") val zipCode: String,
    @field:NotEmpty(message = "invalid input") val streat: String
) {
    fun toEntity(custmer: Custmer): Custmer {
        custmer.firstName = this.firstName
        custmer.lastName = this.lastName
        custmer.income = this.income
        custmer.address.streat = this.streat
        custmer.address.zipCode = this.zipCode
        return custmer
    }

}
