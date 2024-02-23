package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.Custmer


interface ICustmerService {
    fun save(custmer: Custmer):Custmer
    fun findById(id: Long):Custmer
    fun delate(id:Long)
}