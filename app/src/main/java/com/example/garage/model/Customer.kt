package com.example.garage.model

data class Customer(
    val birthdate: String,
    val comment: String,
    val email: String,
    val gender: String,
    val id: String,
    val name: String,
    val shouldReceiveOrderStatusNotifications: Boolean,
    val shouldReceivePromoActionsInfo: Boolean,
    val surname: String
)