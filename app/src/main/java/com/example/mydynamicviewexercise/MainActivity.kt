package com.example.mydynamicviewexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var root: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        root = findViewById(R.id.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val names = listOf("Ghana","Fiji","Greece","Nigeria","Poland","Turkey","Yemen","Zimbabwe")
        if (item.itemId == R.id.add){
            val randomIndex = Random.nextInt(8)
            val title = names[randomIndex]
            addButton(title)
        }
        return true
    }

    private fun addButton(title: String){
        val button = Button(this)
        button.text = title
        root.addView(button)
        button.setOnClickListener{
            root.removeView(it)
        }

    }

}