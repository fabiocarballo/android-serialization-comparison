package com.example.serializationcomparison

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gson.GsonDeserializer
import com.example.kxs.KxsDeserializer
import com.example.moshi.MoshiDeserializer
import com.example.serializationcomparison.databinding.ActivityMainBinding

@ExperimentalStdlibApi
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val gsonDeserializer = GsonDeserializer()
    private val moshiDeserializer = MoshiDeserializer()
    private val kxsDeserializer = KxsDeserializer()

    private val jsonText by lazy {
        assets.open("survey_response.json").bufferedReader()
            .use { it.readText() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.kxsButton.setOnClickListener {
            binding.textResult.text = "Kxs: ${kxsDeserializer.deserialize(jsonText)}"
        }

        binding.gsonButton.setOnClickListener {
            binding.textResult.text = "Gson: ${gsonDeserializer.deserialize(jsonText)}"
        }

        binding.moshiButton.setOnClickListener {
            binding.textResult.text = "Moshi: ${moshiDeserializer.deserialize(jsonText)}"
        }
    }
}