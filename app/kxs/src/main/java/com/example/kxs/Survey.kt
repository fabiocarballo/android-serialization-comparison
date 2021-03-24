package com.example.kxs

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Survey(
    val id: String,
    val pages: List<Page>
)

@Serializable
data class Page(
    val title: String,
    val subtitle: String,
    val questions: List<Question>
)

@Serializable
sealed class Question

@Serializable
@SerialName("comment")
data class CommentQuestion(
    val id: String,
    val type: String
) : Question()

@Serializable
@SerialName("pills")
data class PillsQuestion(
    val id: String,
    val type: String,
    val options: List<Pill>
) : Question() {

    @Serializable
    data class Pill(
        val id: String,
        val text: String
    )
}
