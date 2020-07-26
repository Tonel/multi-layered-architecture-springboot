package com.multilayered.springboot.dao

import com.multilayered.springboot.model.Author
import com.multilayered.springboot.model.Author_
import org.springframework.stereotype.Repository

@Repository
class AuthorDao : EntityDao<Author, Int>() {
    override var entity : Class<Author>? = Author::class.java

    fun findByName(
        name : String
    ) : List<Author> {
        val criteriaBuilder = getCriteriaBuilder()
        val criteriaQuery = getCriteriaQuery()
        val root = criteriaQuery.from(entity)

        val query =
            criteriaQuery
                .select(root)
                .where(
                    criteriaBuilder.like(root.get(Author_.name), "%$name%")
                )

        return getQuery(query).resultList
    }
}