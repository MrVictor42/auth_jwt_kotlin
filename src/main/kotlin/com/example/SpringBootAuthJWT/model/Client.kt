package com.example.SpringBootAuthJWT.model

import com.fasterxml.jackson.annotation.JsonFormat
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.Hibernate
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.PrePersist

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
data class Client (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id : Int,
    @Column(nullable = false, length = 60)
    var name : String = "",
    @Column(nullable = false, length = 11)
    var cpf : String = "",
    @Column(name = "register_data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    var registerData : LocalDate?
) {
    constructor() : this (
        0, "", "", null,
    )

    @PrePersist
    fun prePersit() {
        registerData = LocalDate.now()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Client

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , cpf = $cpf , registerData = $registerData )"
    }
}