package com.example.garage.model

data class Price(
    val currentPrice: Int,
    val isIncludedInMenu: Boolean,
    val nextDatePrice: String,
    val nextIncludedInMenu: Boolean,
    val nextPrice: Int
)