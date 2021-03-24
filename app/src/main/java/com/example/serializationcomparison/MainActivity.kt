package com.example.serializationcomparison

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.gson.GsonDeserializer
import com.example.serializationcomparison.databinding.ActivityMainBinding

@ExperimentalStdlibApi
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val deserializer = GsonDeserializer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            val text = view.context.assets.open("survey_response.json").bufferedReader()
                .use { it.readText() }
            val survey = deserializer.deserialize(text)
            Log.d("Tag", survey.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}