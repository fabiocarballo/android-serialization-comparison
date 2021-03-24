package com.example.kxs

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class KxsDeserializer {

    private val json = Json { }

    fun deserialize(string: String): Survey {
        return json.decodeFromString(string)
    }
}