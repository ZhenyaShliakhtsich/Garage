package com.example.garage.model

import com.example.garage.DiscountsInfo

data class Order(
    val combos: List<Any>,
    val comment: String,
    val completeBefore: String,
    val customer: Customer,
    val deliveryPoint: DeliveryPoint,
    val discountsInfo: DiscountsInfo,
    val externalNumber: String,
    val guests: Guests,
    val id: String,
    val iikoCard5Info: IikoCard5Info,
    val items: List<Item>,
    val marketingSourceId: String,
    val operatorId: String,
    val orderServiceType: String,
    val orderTypeId: String,
    val payments: List<Any>,
    val phone: String,
    val sourceKey: String,
    val tips: List<Any>
)





