package com.example.garage.ui.adapter.recyclerView

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.garage.databinding.ItemCategoriesBinding
import com.example.garage.model.ProductCategory

interface CategoriesClickListener {
    fun onCategoryClick(category: ProductCategory)
}

class CategoriesAdapter(
    private val context: Context,
    private var actionListener: CategoriesClickListener
) :
    RecyclerView.Adapter<CategoriesViewHolder>(), View.OnClickListener {

    var categoriesList = ArrayList<ProductCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding = ItemCategoriesBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        binding.root.setOnClickListener(this)
        return CategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    override fun getItemCount(): Int = categoriesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<ProductCategory>) {
        categoriesList = list as ArrayList<ProductCategory>
        notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        val category = v?.tag as ProductCategory
        actionListener.onCategoryClick(category)
    }

}