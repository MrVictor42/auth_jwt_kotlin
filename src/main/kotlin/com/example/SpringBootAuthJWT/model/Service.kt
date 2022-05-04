package com.example.SpringBootAuthJWT.model

import lombok.Data
import org.hibernate.Hibernate
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
@Data
data class Service (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id : Int,
    @Column(nullable = false, length = 150)
    private var description : String,
    @ManyToOne
    @JoinColumn(name = "id_client")
    private val client : Client?,
    @Column
    var valor : BigDecimal = BigDecimal(0)
) {
    constructor() : this (
        0, "", null
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Service

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , description = $description , client = $client )"
    }
}