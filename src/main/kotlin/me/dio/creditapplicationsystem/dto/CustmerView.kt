package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.Custmer
import java.math.BigDecimal

data class CustmerView (
    val firsName:String,
    val lastName:String,
    val cpf:String,
    val income:BigDecimal,
    val email:String,
    val zipCode:String,
    val strat:String
){
    constructor(custmer:Custmer):this(
        firsName = custmer.firstName,
        lastName = custmer.lastName,
        cpf = custmer.cpf,
        income = custmer.income,
        email = custmer.email,
        zipCode = custmer.address.zipCode,
        strat = custmer.address.zipCode
    )
}
