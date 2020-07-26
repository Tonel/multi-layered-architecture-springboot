package com.multilayered.springboot.controller

import com.multilayered.springboot.dto.AuthorDto
import com.multilayered.springboot.dto.SpecialAuthorDto
import com.multilayered.springboot.dto.mapper.AuthorMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@RestController
@RequestMapping("/authors")
class AuthorController : CustomController() {
    @Autowired
    lateinit var authorMapper: AuthorMapper

    @GetMapping("v1/")
    fun getAll() : ResponseEntity<List<AuthorDto>> {
        return ResponseEntity(
            authorMapper.authorsToAuthorDtos(
                authorService.getAll()
            ), HttpStatus.OK)
    }

    @GetMapping("v1/special/{id}")
    fun getSpecial(@PathVariable(value = "id") id: Int) : ResponseEntity<SpecialAuthorDto> {
        return ResponseEntity(
            authorMapper.authorToSpecialAuthorDto(
                authorService.getByKey(id)
            ), HttpStatus.OK)
    }

    @GetMapping("v1/{id}")
    fun get(@PathVariable(value = "id") id: Int) : ResponseEntity<AuthorDto> {
        return ResponseEntity(
            authorMapper.authorToAuthorDto(
                authorService.getByKey(id)
            ), HttpStatus.OK)
    }

    @GetMapping("v1/find")
    fun findByName(
        @RequestParam(value = "name", required = true) @NotEmpty @NotBlank name: String
    ) : ResponseEntity<List<AuthorDto>> {
        return ResponseEntity(
            authorMapper.authorsToAuthorDtos(
                authorService.getByName(name)
            ), HttpStatus.OK)
    }

}