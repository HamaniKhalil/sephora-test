package com.sephoratest.network.products.dtos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductImagesDto(
    @SerializedName("small")
    val smallUrl: String,
    @SerializedName("large")
    val largeUrl: String,
): Serializable
