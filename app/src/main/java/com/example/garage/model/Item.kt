package com.example.garage.model

data class Item(
    var amount: Int,
    val comboInformation: ComboInformation? = null,
    val comment: String? = null,
    val productSizeId: String,
    val id: String
)

