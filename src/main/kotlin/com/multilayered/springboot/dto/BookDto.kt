package com.multilayered.springboot.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class BookDto {

    @JsonProperty("id")
    var id: Int? = null

    @JsonProperty("title")
    var title: String? = null

    @JsonProperty("releaseDate")
    @JsonFormat(pattern = "MM/dd/yyyy")
    var releaseDate: Date? = null

}