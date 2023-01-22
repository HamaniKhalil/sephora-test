package com.sephoratest.domain.products.usecases

import com.sephoratest.domain.products.repositories.ProductRepository

abstract class GetAllProductsUseCase(private val productRepository: ProductRepository) {

    suspend operator fun invoke() =
        productRepository.getAll()
}