package me.dio.creditapplicationsystem.controler

import jakarta.validation.Valid
import me.dio.creditapplicationsystem.dto.CreditDto
import me.dio.creditapplicationsystem.dto.CreditView
import me.dio.creditapplicationsystem.dto.CreditViewList
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResorce(
    private val creditService: CreditService
) {

    @PostMapping
    fun saveCredits(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String> {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - Custmer ${credit.custmer?.firstName} saved !")
    }

    @GetMapping
    fun findAllByCustmerId(@RequestParam(value = "custmerId") custmerId: Long): ResponseEntity<List<CreditViewList>> {
        val creditViewList: List<CreditViewList> = this.creditService.findAllByCustmer(custmerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(value = "custmerId") custmerId: Long,
        @PathVariable creditCode: UUID
    ): ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(creditCode, custmerId)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}