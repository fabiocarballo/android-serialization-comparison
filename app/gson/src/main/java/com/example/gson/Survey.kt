package com.example.gson

import com.google.gson.annotations.SerializedName


data class Survey(
    @SerializedName("id")
    val id: String,
    @SerializedName("pages")
    val pages: List<Page>
)

data class Page(
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("questions")
    val questions: List<Question>
)

interface Question

data class CommentQuestion(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String
) : Question

data class PillsQuestion(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("options")
    val options: List<Pill>
) : Question {

    data class Pill(
        @SerializedName("id")
        val id: String,
        @SerializedName("text")
        val text: String
    )
}