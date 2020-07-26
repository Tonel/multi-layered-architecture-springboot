package com.multilayered.springboot.dto.mapper

import com.multilayered.springboot.dto.BookDto
import com.multilayered.springboot.model.Book
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface BookMapper {

    fun bookToBookDto(
        book : Book
    ) : BookDto

    fun booksToBookDtos(
        books : List<Book>
    ) : List<BookDto>

}