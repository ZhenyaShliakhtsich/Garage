package com.example.garage.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.garage.DISH
import com.example.garage.R
import com.example.garage.databinding.FragmentBasketBinding
import com.example.garage.model.CartItem
import com.example.garage.ui.adapter.ProductsViewModel
import com.example.garage.ui.adapter.recyclerView.BasketAdapter
import com.example.garage.ui.adapter.recyclerView.BasketClickListener

class BasketFragment : Fragment(R.layout.fragment_basket) {

    private lateinit var binding: FragmentBasketBinding
    var viewModel = ProductsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasketBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cart.observe(viewLifecycleOwner) {
            if (it.isNullOrEmpty()) {
                binding.createOrderButton.isVisible = false
                binding.createOrderButton.isEnabled = false
            } else {
                binding.createOrderButton.isVisible = true
                binding.createOrderButton.isEnabled = true
            }
            val adapter = BasketAdapter(requireContext(), object : BasketClickListener {
                override fun onItemClick(product: CartItem) {
                    findNavController().navigate(R.id.dishFragment).apply {
                        bundleOf(DISH to product)
                    }
                }

                override fun onPlusClick(product: CartItem) {
                    viewModel.plusAmount(product)
                }

                override fun onMinusClick(product: CartItem) {
                    viewModel.minusAmount(product)
                }
            })
            adapter.setList(it)
            binding.basketRecyclerView.adapter = adapter
            binding.basketSum.text = R.string.total_sum.toString() + " : " +
                    it.sumOf {  it.amount * it.product.sizePrices[0].price.currentPrice }
        }
    }

}

