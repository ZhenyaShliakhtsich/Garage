package com.example.garage.ui.adapter.recyclerView

import androidx.recyclerview.widget.RecyclerView
import com.example.garage.model.CartItem
import com.squareup.picasso.Picasso

class BasketViewHolder(private var binding: com.example.garage.databinding.ItemBasketBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CartItem) {
        binding.dishName.text = item.product.name
        binding.dishDescription.text = item.product.description
        Picasso.get().load(item.product.imageLinks[0]).into(binding.basketImage)
        binding.amount.text = item.amount.toString()
        binding.price.text =
            (item.amount * item.product.sizePrices[0].price.currentPrice).toString()
    }
}

