package com.example.garage.model


data class DeliveryPoint(
    val address: Address,
    val comment: String,
    val coordinates: Coordinates,
    val externalCartographyId: String
)


