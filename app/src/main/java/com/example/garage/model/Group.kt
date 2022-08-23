package com.example.garage.model

data class Group(
    val additionalInfo: String,
    val code: String,
    val description: String,
    val id: String,
    val imageLinks: List<String>,
    val isDeleted: Boolean,
    val isGroupModifier: Boolean,
    val isIncludedInMenu: Boolean,
    val name: String,
    val order: Int,
    val parentGroup: String,
    val seoDescription: String,
    val seoKeywords: String,
    val seoText: String,
    val seoTitle: String,
    val tags: List<String>
)