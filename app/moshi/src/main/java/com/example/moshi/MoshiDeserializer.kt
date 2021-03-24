package com.example.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

@ExperimentalStdlibApi
class MoshiDeserializer {

    private val moshi = Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(Question::class.java, "type")
                .withSubtype(CommentQuestion::class.java, "comment")
                .withSubtype(PillsQuestion::class.java, "pills")
        )
        .build()

    fun deserialize(string: String): Survey {
        return moshi.adapter<Survey>().fromJson(string)!!
    }
}