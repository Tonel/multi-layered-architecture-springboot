package com.multilayered.springboot.service

import com.multilayered.springboot.model.Author
import org.springframework.stereotype.Service

@Service
class AuthorService : CustomService() {

    fun getByKey(key : Int) : Author {
        return authorDao.findByKey(key).get()
    }

    fun getByName(name : String) : List<Author> {
        return authorDao.findByName(name)
    }

    fun getAll() : List<Author> {
        return authorDao.findAll()
    }
}