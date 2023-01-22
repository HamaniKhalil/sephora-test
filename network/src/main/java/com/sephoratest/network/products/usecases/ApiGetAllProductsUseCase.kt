package com.sephoratest.network.products.usecases

import com.sephoratest.domain.products.usecases.GetAllProductsUseCase
import com.sephoratest.network.products.repositories.ApiProductRepository

class ApiGetAllProductsUseCase(repository: ApiProductRepository) :
    GetAllProductsUseCase(repository)