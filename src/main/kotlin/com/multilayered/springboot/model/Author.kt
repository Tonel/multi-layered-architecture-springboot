package com.multilayered.springboot.model

import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
@Table(name = "author")
open class Author {
    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @get:Column(name = "id", unique = true, nullable = false)
    open var id: Int? = null

    @get:Basic
    @get:Column(name = "name", nullable = false, length = 50)
    open var name: String? = null

    @get:Basic
    @get:Column(name = "surname", nullable = false, length = 50)
    open var surname: String? = null

    @get:Basic
    @get:Column(name = "birthDate", nullable = true)
    @get:Temporal(TemporalType.DATE)
    open var birthDate: Date? = null

    @get:ManyToMany(fetch = FetchType.LAZY)
    @get:JoinTable(
        name = "author_book",
        joinColumns = [JoinColumn(name = "author_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    open var books: MutableSet<Book> = HashSet()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Author

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        if (id == null)
            return 0

        return id!!
    }
}