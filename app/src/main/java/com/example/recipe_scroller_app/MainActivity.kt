package com.example.recipe_scroller_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val recipes = listOf(
            Recipe("Pasta", "Creamy white sauce pasta", R.drawable.pasta),
            Recipe("Pizza", "Cheese burst Italian pizza", R.drawable.pizza),
            Recipe("Biryani", "Spicy Hyderabadi biryani", R.drawable.biryani),
            Recipe("Burger", "Cheese loaded burger", R.drawable.burger),
            Recipe("Salad", "Fresh veggie salad", R.drawable.salad)
        )

            recyclerView.adapter = RecipeAdapter(recipes)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}