package com.sephoratest.network.products.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sephoratest.network.products.repositories.ApiProductRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ApiGetAllProductsUseCaseUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val productRepository: ApiProductRepository = mockk()
    private val apiGetAllProductsUseCase = ApiGetAllProductsUseCase(repository = productRepository)

    @Before
    fun init() {
        coEvery { productRepository.getAll() } returns mockk()
    }

    @Test
    fun shouldUseRepositoryToGetAllProducts() = runTest {
        apiGetAllProductsUseCase()

        coVerify { productRepository.getAll() }
    }

}