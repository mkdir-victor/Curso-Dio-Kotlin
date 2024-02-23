package me.dio.creditapplicationsystem.entity

import jakarta.persistence.*
import java.math.BigDecimal

/* anotação
@OneToMany --> relacionamento 1..n
@Column --> criam a restrição da coluna, ex se pode ter mesmo valor, pode ser nulo, ...
@Id --> define que é uma chave primaria
@GenerateValue --> define como que esse chave primaria vai ser modificado
@Embedded --> insere uma tabela @Embeddable
* */


@Entity // anotação que cria a tabela em  banco de dado
@Table(name = "Client")// defini a nome da tabela
data class Custmer(
    @Column(nullable = false) var firstName: String = "",
    @Column(nullable = false) var lastName: String = "",
    @Column(nullable = false, unique = true) var cpf: String = "",
    @Column(nullable = false, unique = true) var email: String = "",
    @Column(nullable = false) var income:BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) var password: String = "",
    @Column(nullable = false) @Embedded var address: Address = Address(),
    @Column(nullable = false) @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf( CascadeType.REMOVE, CascadeType.PERSIST),
        mappedBy = "custmer")
    var credits: List<Credit> = mutableListOf(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null// definido que é a chave primaria e forma de ser inclementado
)