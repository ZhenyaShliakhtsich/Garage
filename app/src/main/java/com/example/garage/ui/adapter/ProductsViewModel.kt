package com.example.garage.ui.adapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.garage.model.CartItem
import com.example.garage.model.Menu
import com.example.garage.model.Product
import com.example.garage.model.ProductCategory
import com.example.garage.network.NetworkController.getIIkoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    val categoryProductsList = MutableLiveData<List<Product>?>()

    val productCategoriesList = MutableLiveData<List<ProductCategory>>()

    val cart = MutableLiveData<ArrayList<CartItem>>()

    val menu = MutableLiveData<Menu>()

    fun getProducts(id: String) {
        val categoryProducts = menu.value?.products?.filter { if(it.productCategoryId == id);true }
        categoryProductsList.postValue(categoryProducts)
    }

    fun getMenu() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getIIkoApi().getMenu()
            if (response.isSuccessful) {
                menu.postValue(response.body())
            }
        }
    }

    fun getCategories() {
        productCategoriesList.postValue(menu.value?.productCategories)
    }

    fun addToCart(product: Product, amount: Int) {
        var list: ArrayList<CartItem>? = cart.value
        if (list.isNullOrEmpty()) {
            list = ArrayList()
        }
        val cartItem = CartItem(product, amount)
        list.add(cartItem)
        cart.postValue(list!!)
    }

    fun plusAmount(cartItem: CartItem) {
        cartItem.amount += 1
    }

    fun minusAmount(cartItem: CartItem) {
        cartItem.amount -= 1
    }
}