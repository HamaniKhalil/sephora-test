package com.sephoratest.network.products.repositories

import com.sephoratest.domain.products.models.Product
import com.sephoratest.domain.products.repositories.ProductRepository
import com.sephoratest.network.products.mappers.ApiProductMapper
import com.sephoratest.network.products.services.ProductsService
import com.sephoratest.network.util.extensions.handle

class ApiProductRepository(
    private val service: ProductsService
) : ProductRepository {

    private val apiProductMapper = ApiProductMapper()

    override suspend fun getAll(): Result<List<Product>> =
        runCatching {
            service.getAll()
                .execute()
                .handle()
        }
            .map { it.map(apiProductMapper::from) }
}