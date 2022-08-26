package com.example.garage.ui.adapter.recyclerView

import androidx.recyclerview.widget.RecyclerView
import com.example.garage.model.Product
import com.squareup.picasso.Picasso

class CategoryViewHolder(private var binding: com.example.garage.databinding.ItemCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Product) {
        binding.dishName.text = item.name
        binding.dishDescription.text = item.description
        binding.mass.text = item.weight.toString()
        Picasso.get().load(item.imageLinks[0]).into(binding.dishImage)

    }
}
