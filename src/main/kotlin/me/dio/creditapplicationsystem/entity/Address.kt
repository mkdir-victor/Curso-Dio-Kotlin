package me.dio.creditapplicationsystem.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

// não cria uma tabela nova, vai ser inserido direto em uma tabela inserida
@Embeddable
data class Address(
    @Column(nullable = false) var zipCode: String = "",
    @Column(nullable = false) var streat: String = ""
)
