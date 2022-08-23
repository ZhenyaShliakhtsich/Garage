package com.example.garage.model

data class GroupModifier(
    val childModifiers: List<ChildModifier>,
    val childModifiersHaveMinMaxRestrictions: Boolean,
    val defaultAmount: Int,
    val freeOfChargeAmount: Int,
    val hideIfDefaultAmount: Boolean,
    val id: String,
    val maxAmount: Int,
    val minAmount: Int,
    val required: Boolean,
    val splittable: Boolean
)