package com.multilayered.springboot.dto.mapper

import com.multilayered.springboot.dto.AuthorDto
import com.multilayered.springboot.dto.BookDto
import com.multilayered.springboot.dto.SpecialAuthorDto
import com.multilayered.springboot.model.Author
import com.multilayered.springboot.model.Book
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
abstract class AuthorMapper {

    abstract fun authorToAuthorDto(
        author : Author
    ) : AuthorDto

    abstract fun authorsToAuthorDtos(
        authors : List<Author>
    ) : List<AuthorDto>

    // author's book property is accessed through java setter
    @Mappings(
        Mapping(target="firstBook", expression = "java(booksToFirstBook(author.getBooks()))")
    )
    abstract fun authorToSpecialAuthorDto(
        author : Author
    ) : SpecialAuthorDto

    // required in order to convert Book into BookDto
    // in booksToFirstBook
    abstract fun bookToBookDto(
        book : Book
    ) : BookDto

    // converting books into the first book released
    fun booksToFirstBook(books : Set<Book>) : BookDto {
        return bookToBookDto(
            books
                .filter { it.releaseDate != null }
                .sortedWith(Comparator { e1: Book, e2: Book -> compareValues(e1.releaseDate, e2.releaseDate) })
                .first()
        )
    }

}