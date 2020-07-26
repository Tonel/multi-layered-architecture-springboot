package com.multilayered.springboot.service

import com.multilayered.springboot.dao.AuthorDao
import com.multilayered.springboot.dao.BookDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
abstract class CustomService {

    @Autowired
    protected lateinit var authorDao: AuthorDao

    @Autowired
    protected lateinit var bookDao: BookDao

}