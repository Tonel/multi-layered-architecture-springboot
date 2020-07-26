package com.multilayered.springboot.controller

import com.multilayered.springboot.dto.BookDto
import com.multilayered.springboot.dto.mapper.BookMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@RestController
@RequestMapping("/books")
class BookController : CustomController() {

    @Autowired
    protected lateinit var bookMapper: BookMapper

    @GetMapping("v1")
    fun getAll() : ResponseEntity<List<BookDto>> {
        return ResponseEntity(
            bookMapper.booksToBookDtos(
                bookService.getAll()
            ), HttpStatus.OK)
    }

    @GetMapping("v1/{id}")
    fun get(@PathVariable(value = "id") id: Int) : ResponseEntity<BookDto> {
        return ResponseEntity(
            bookMapper.bookToBookDto(
                bookService.getByKey(id)
            ), HttpStatus.OK)
    }

    @GetMapping("v1/find")
    fun findByName(
        @RequestParam(value = "title", required = true) @NotEmpty @NotBlank title: String
    ) : ResponseEntity<List<BookDto>> {
        return ResponseEntity(
            bookMapper.booksToBookDtos(
                bookService.getByTitle(title)
            ), HttpStatus.OK)
    }

}