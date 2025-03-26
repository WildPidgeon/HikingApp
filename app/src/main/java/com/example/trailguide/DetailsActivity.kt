package com.example.trailguide

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)



        val imageView: ImageView = findViewById(R.id.imageViewTrail)
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewDescription: TextView = findViewById(R.id.textViewDescription)
        val listViewStages: ListView = findViewById(R.id.listViewStages)

        val name = intent.getStringExtra("trail_name")
        val description = intent.getStringExtra("trail_description")
        val imageResId = intent.getIntExtra("trail_image", 0)
        val stages = intent.getStringArrayListExtra("trail_stages")

        textViewName.text = name
        textViewDescription.text = description
        imageView.setImageResource(imageResId)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stages!!)
        listViewStages.adapter = adapter


        if (savedInstanceState == null) {
            val stopwatchFragment = StopwatchFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.stopwatchContainer, stopwatchFragment)
                .commit()
        }

        val fabCapture: FloatingActionButton = findViewById(R.id.fab_capture)


        fabCapture.setOnClickListener {

            Toast.makeText(this, "Aparat włączony!", Toast.LENGTH_SHORT).show()
        }
        Log.d("DetailsActivity", "Layout loaded for orientation: " + resources.configuration.orientation)
        Log.d("DetailsActivity", "Trail Name: $name")

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = "Szczegóły Szlaku"
    }
}