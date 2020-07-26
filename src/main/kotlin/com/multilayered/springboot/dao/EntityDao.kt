package com.multilayered.springboot.dao

import org.springframework.stereotype.Repository
import java.io.Serializable
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery

@Repository
abstract class EntityDao<T, KEY : Serializable?> {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager

    protected var entity : Class<T>? = null

    fun findByKey(key: KEY): Optional<T> {
        return Optional.of(entityManager.find(entity, key))
    }

    fun findAll(): List<T> {
        val criteriaQuery = getCriteriaQuery()
        val root =  criteriaQuery.from(entity)
        val resultQuery = getQuery(criteriaQuery.select(root))

        return resultQuery.resultList
    }

    fun create(entity: T) : T {
        entityManager.persist(entity)

        return entity
    }

    fun update(entity: T) : T {
        return entityManager.merge(entity)
    }

    fun delete(entity: T) : T {
        entityManager.remove(entity)

        return entity
    }

    protected fun getCriteriaBuilder(): CriteriaBuilder {
        return entityManager.criteriaBuilder
    }

    protected fun getCriteriaQuery(): CriteriaQuery<T> {
        return entityManager.criteriaBuilder.createQuery(entity)
    }

    protected fun getQuery(criteriaQuery : CriteriaQuery<T>): TypedQuery<T> {
        return entityManager.createQuery(criteriaQuery)
    }

}