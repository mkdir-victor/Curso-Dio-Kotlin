package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Address
import me.dio.creditapplicationsystem.entity.Custmer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustmerDto(
    @field:NotEmpty(message = "invalid input") val firstName: String,
    @field:NotEmpty(message = "invalid input") val lastName: String,
    @field:NotEmpty(message = "invalid input")
    @field:CPF(message = "this is invalid cpf") val cpf: String,
    @field:NotNull(message = "invalid input") val income: BigDecimal,
    @field:Email(message = "invalid email")
    @field:NotEmpty(message = "invalid input") val email: String,
    @field:NotEmpty(message = "invalid input") val password: String,
    @field:NotEmpty(message = "invalid input") val zipCode: String,
    @field:NotEmpty(message = "invalid input") val streat: String
) {

    fun toEntity(): Custmer = Custmer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        email = this.email,
        income = this.income,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            streat = this.streat
        )
    )

}
