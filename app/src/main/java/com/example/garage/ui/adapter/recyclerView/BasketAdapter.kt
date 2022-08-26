package com.example.garage.ui.adapter.recyclerView

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.garage.R
import com.example.garage.databinding.ItemBasketBinding
import com.example.garage.model.CartItem

interface BasketClickListener {
    fun onItemClick(product: CartItem)
    fun onPlusClick(product: CartItem)
    fun onMinusClick(product: CartItem)
}

class BasketAdapter(private val context: Context, private var actionListener: BasketClickListener) :
    RecyclerView.Adapter<BasketViewHolder>(),
    View.OnClickListener {

    var basketList = ArrayList<CartItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val binding = ItemBasketBinding.inflate(
            LayoutInflater.from(context), parent, false
        )

        return BasketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.bind(basketList[position])
    }

    override fun getItemCount(): Int = basketList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<CartItem>) {
        basketList = list
        notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        val dish = v?.tag as CartItem
        val plusButton = v.findViewById<Button>(R.id.plus_button)
        val minusButton = v.findViewById<Button>(R.id.minus_button)
        if (v.id == plusButton?.id) {
            actionListener.onPlusClick(dish)
        } else if (v.id == minusButton.id) {
            actionListener.onMinusClick(dish)
        } else {
            actionListener.onItemClick(dish)
        }
    }

}
