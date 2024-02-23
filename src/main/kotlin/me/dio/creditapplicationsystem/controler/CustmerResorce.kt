package me.dio.creditapplicationsystem.controler

import jakarta.validation.Valid
import me.dio.creditapplicationsystem.dto.CustmerDto
import me.dio.creditapplicationsystem.dto.CustmerUpdateDto
import me.dio.creditapplicationsystem.dto.CustmerView
import me.dio.creditapplicationsystem.entity.Custmer
import me.dio.creditapplicationsystem.service.impl.CustmerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/custmers")
class CustmerResorce(
    private val custmerService: CustmerService
) {

    @PostMapping
    fun saveCustmer(@RequestBody @Valid custmerDto: CustmerDto): ResponseEntity<String> {
        val savedCustmer = this.custmerService.save(custmerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Custmer: ${savedCustmer.email} saved !")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustmerView> {
        val custmer: Custmer = this.custmerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustmerView(custmer))
    }

    @DeleteMapping("/{id}")
    fun deleatCustmer(@PathVariable id: Long) = this.custmerService.delate(id)

    @PatchMapping
    fun updateCustmer(
        @RequestParam(value = "custmerId") id: Long,
        @RequestBody @Valid custmerUpdateDto: CustmerUpdateDto
    ): ResponseEntity<CustmerView> {
        val custmer: Custmer = this.custmerService.findById(id)
        val custmerToUpdate: Custmer = custmerUpdateDto.toEntity(custmer)
        val custmerUpdated: Custmer = this.custmerService.save(custmerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustmerView(custmerUpdated))
    }
}