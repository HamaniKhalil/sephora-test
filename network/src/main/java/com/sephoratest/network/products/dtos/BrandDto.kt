package com.sephoratest.network.products.dtos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BrandDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
): Serializable
