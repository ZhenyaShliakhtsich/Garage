package com.example.garage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.garage.DISH
import com.example.garage.R
import com.example.garage.databinding.FragmentCategoryBinding
import com.example.garage.model.Product
import com.example.garage.ui.adapter.ProductsViewModel
import com.example.garage.ui.adapter.recyclerView.CategoryAdapter
import com.example.garage.ui.adapter.recyclerView.CategoryClickListener

class CategoryFragment : Fragment(R.layout.fragment_category) {
    private lateinit var binding: FragmentCategoryBinding
    private val viewModel = ProductsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.categoryProductsList.observe(viewLifecycleOwner) {
            val adapter = CategoryAdapter(requireContext(), object : CategoryClickListener {
                override fun onDishClick(product: Product) {
                    findNavController().navigate(R.id.dishFragment).apply {
                        bundleOf(DISH to product)
                    }
                }

                override fun onButtonClick(product: Product) {
                viewModel.addToCart(product,1)
                    Toast.makeText(context, R.string.dish_added, Toast.LENGTH_SHORT).show()
                }
            })
            adapter.setList(it as ArrayList<Product>)
            binding.categoryRecyclerView.adapter = adapter


        }


    }
}
