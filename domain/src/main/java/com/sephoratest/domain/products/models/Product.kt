package com.sephoratest.domain.products.models

data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val price: Double,
    val images: ProductImages,
    val brand: Brand,
    val isProductSet: Boolean,
    val isSpecialBrand: Boolean
)
