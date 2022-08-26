package com.example.garage.ui.adapter.recyclerView

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.garage.R
import com.example.garage.databinding.ItemCategoryBinding
import com.example.garage.model.Product


interface CategoryClickListener {
    fun onDishClick(product: Product)
    fun onButtonClick(product: Product)
}

class CategoryAdapter(
    private val context: Context,
    private var actionListener: CategoryClickListener
) :
    RecyclerView.Adapter<CategoryViewHolder>(),
    View.OnClickListener {

    var dishesList = ArrayList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        binding.root.setOnClickListener(this)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(dishesList[position])
    }

    override fun getItemCount(): Int = dishesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Product>) {
        dishesList = list
        notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        val dish = v?.tag as Product
        val button = v.findViewById<Button>(R.id.price)
        if (v.id == button?.id) {
            actionListener.onButtonClick(dish)
        } else {
            actionListener.onDishClick(dish)
        }
    }

}
