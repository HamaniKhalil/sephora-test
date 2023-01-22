package com.sephoratest.domain.products.repositories

import com.sephoratest.domain.products.models.Product

interface ProductRepository {

    suspend fun getAll(): Result<List<Product>>
}