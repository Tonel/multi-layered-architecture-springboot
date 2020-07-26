package com.multilayered.springboot.service

import com.multilayered.springboot.model.Book
import org.springframework.stereotype.Service

@Service
class BookService : CustomService() {

    fun getByKey(key : Int) : Book {
        return bookDao.findByKey(key).get()
    }

    fun getByTitle(title : String) : List<Book> {
        return bookDao.findByTitle(title)
    }

    fun getAll() : List<Book> {
        return bookDao.findAll()
    }
}