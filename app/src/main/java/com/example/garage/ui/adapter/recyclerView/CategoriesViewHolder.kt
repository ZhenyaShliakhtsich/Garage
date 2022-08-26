package com.example.garage.ui.adapter.recyclerView

import androidx.recyclerview.widget.RecyclerView
import com.example.garage.model.ProductCategory

class CategoriesViewHolder(private var binding: com.example.garage.databinding.ItemCategoriesBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ProductCategory) {
        binding.itemText.text = item.name
        // Picasso.get().load()

    }
}