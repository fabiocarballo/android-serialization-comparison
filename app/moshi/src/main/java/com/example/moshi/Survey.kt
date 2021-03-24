package com.example.moshi

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Survey(
    val id: String,
    val pages: List<Page>
)

@JsonClass(generateAdapter = true)
data class Page(
    val title: String,
    val subtitle: String,
    val questions: List<Question>
)

sealed class Question(@Json(name = "type") val type: String)

@JsonClass(generateAdapter = true)
data class CommentQuestion(
    val id: String,
) : Question("comment")

@JsonClass(generateAdapter = true)
data class PillsQuestion(
    val id: String,
    val options: List<Pill>
) : Question("pills") {

    @JsonClass(generateAdapter = true)
    data class Pill(
        val id: String,
        val text: String
    )
}