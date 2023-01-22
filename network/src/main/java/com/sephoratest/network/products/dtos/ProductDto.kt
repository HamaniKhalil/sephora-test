package com.sephoratest.network.products.dtos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("product_name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("images_url")
    val images: ProductImagesDto,
    @SerializedName("c_brand")
    val brand: BrandDto,
    @SerializedName("isProductSet")
    val isProductSet: Boolean,
    @SerializedName("isSpecialBrand")
    val isSpecialBrand: Boolean,
): Serializable
