package com.example.gson

import com.google.gson.GsonBuilder

class GsonDeserializer {

    private val questionAdapterFactory = RuntimeTypeAdapterFactory.of(Question::class.java)
        .registerSubtype(CommentQuestion::class.java, "comment")
        .registerSubtype(PillsQuestion::class.java, "pills")

    private val gson = GsonBuilder()
        .registerTypeAdapterFactory(questionAdapterFactory)
        .create()

    fun deserialize(string: String): Survey {
        return gson.fromJson(string, Survey::class.java)
    }
}