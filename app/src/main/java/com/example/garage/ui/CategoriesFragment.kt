package com.example.garage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.garage.R
import com.example.garage.databinding.FragmentCategoriesBinding
import com.example.garage.model.ProductCategory
import com.example.garage.ui.adapter.ProductsViewModel
import com.example.garage.ui.adapter.recyclerView.CategoriesAdapter
import com.example.garage.ui.adapter.recyclerView.CategoriesClickListener

class CategoriesFragment : Fragment(R.layout.fragment_categories) {
    private lateinit var binding: FragmentCategoriesBinding
    private val viewModel = ProductsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        viewModel.getCategories()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.productCategoriesList.observe(viewLifecycleOwner){
            val adapter = CategoriesAdapter(requireContext(), object : CategoriesClickListener {
                override fun onCategoryClick(category: ProductCategory) {
                    viewModel.getProducts(category.id)
                    findNavController().navigate(R.id.categoryFragment)
                }
            })
            adapter.setList(it)
            binding.categoriesRecyclerView.adapter = adapter
        }

    }
}