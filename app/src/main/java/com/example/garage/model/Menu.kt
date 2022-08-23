package com.example.garage.model

data class Menu(
    val correlationId: String,
    val groups: List<Group>,
    val productCategories: List<ProductCategory>,
    val products: List<Product>,
    val revision: Int,
    val sizes: List<Size>
)
















