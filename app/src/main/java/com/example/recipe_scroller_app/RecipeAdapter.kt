package com.example.recipe_scroller_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private val recipeList:List<Recipe>) :
 RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imgRecipe : ImageView = itemView.findViewById(R.id.imgRecipe)
        val txtName: TextView = itemView.findViewById(R.id.txtRecipeName)
        val txtDesc:TextView = itemView.findViewById(R.id.txtRecipeDesc)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe,parent,false)
        return RecipeViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.imgRecipe.setImageResource(recipe.imageResId)
        holder.txtName.text = recipe.name
        holder.txtDesc.text = recipe.description
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }
}