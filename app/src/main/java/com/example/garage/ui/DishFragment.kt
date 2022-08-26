package com.example.garage.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.garage.DISH
import com.example.garage.R
import com.example.garage.databinding.FragmentDishBinding
import com.example.garage.model.Product
import com.example.garage.ui.adapter.ProductsViewModel
import com.squareup.picasso.Picasso


class  DishFragment : Fragment(R.layout.fragment_dish) {
    private lateinit var binding: FragmentDishBinding
    private val viewModel = ProductsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDishBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dish: Product = this.arguments?.get(DISH) as Product
        var amount = 1
        binding.name.text = dish.name
        binding.description.text = dish.description
        Picasso.get().load(dish.imageLinks[0]).into(binding.image)
        binding.amount.text = amount.toString()
        binding.plusButton.setOnClickListener {
            amount += 1
        }
        binding.minusButton.isEnabled = amount != 1
        binding.minusButton.setOnClickListener {
            amount -= 1
        }
        binding.toBasket.setOnClickListener {
            viewModel.addToCart(dish, amount)
            Toast.makeText(context,R.string.dish_added, Toast.LENGTH_SHORT).show()
        }
        binding.weight.text = dish.weight.toString() + " " + dish.measureUnit
        binding.price.text = (amount * dish.sizePrices[0].price.currentPrice).toString()
        binding.closeButton.setOnClickListener {

        }
    }
}