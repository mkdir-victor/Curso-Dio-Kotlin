package me.dio.creditapplicationsystem.entity

import jakarta.persistence.*
import me.dio.creditapplicationsystem.enumeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "Credito")
data class Credit(
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstalment: LocalDate,
    @Column(nullable = false) val numberOfInsttalment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var custmer: Custmer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
