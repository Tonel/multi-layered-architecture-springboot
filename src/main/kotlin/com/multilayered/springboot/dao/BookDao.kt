package com.multilayered.springboot.dao

import com.multilayered.springboot.model.Book
import com.multilayered.springboot.model.Book_
import org.springframework.stereotype.Repository

@Repository
class BookDao : EntityDao<Book, Int>() {
    override var entity : Class<Book>? = Book::class.java

    fun findByTitle(
        title : String
    ) : List<Book> {
        val criteriaBuilder = getCriteriaBuilder()
        val criteriaQuery = getCriteriaQuery()
        val root = criteriaQuery.from(entity)

        val query =
            criteriaQuery
                .select(root)
                .where(
                    criteriaBuilder.like(root.get(Book_.title), "%$title%")
                )

        return getQuery(query).resultList
    }
}