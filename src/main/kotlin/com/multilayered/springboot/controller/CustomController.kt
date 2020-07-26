package com.multilayered.springboot.controller

import com.multilayered.springboot.service.AuthorService
import com.multilayered.springboot.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated


@Validated
@Transactional(readOnly = true)
abstract class CustomController {

    @Autowired
    protected lateinit var authorService: AuthorService

    @Autowired
    protected lateinit var bookService: BookService

}