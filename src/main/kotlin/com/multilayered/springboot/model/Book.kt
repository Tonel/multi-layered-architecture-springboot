package com.multilayered.springboot.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "book")
open class Book {
    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @get:Column(name = "id", unique = true, nullable = false)
    open var id: Int? = null

    @get:Basic
    @get:Column(name = "title", nullable = false, length = 50)
    open var title: String? = null

    @get:Basic
    @get:Column(name = "releaseDate", nullable = true)
    @get:Temporal(TemporalType.DATE)
    open var releaseDate: Date? = null

    @get:ManyToMany(
        fetch = FetchType.LAZY,
        mappedBy = "books"
    )
    open var authors: MutableSet<Author> = HashSet()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        if (id == null)
            return 0

        return id!!
    }
}