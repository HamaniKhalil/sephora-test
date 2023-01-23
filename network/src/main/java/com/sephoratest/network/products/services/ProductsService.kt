package com.sephoratest.network.products.services

import com.sephoratest.network.products.dtos.ProductDto
import retrofit2.Call
import retrofit2.http.GET

interface ProductsService {

    @GET("items.json")
    fun getAll(): Call<List<ProductDto>>
}