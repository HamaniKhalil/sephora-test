package com.sephoratest.app.ui.models

data class UiProduct(
    val id: Long,
    val name: String,
    val description: String,
    val price: Double,
    val images: UiProductImages,
    val brand: UiBrand,
    val isProductSet: Boolean,
    val isSpecialBrand: Boolean
)
