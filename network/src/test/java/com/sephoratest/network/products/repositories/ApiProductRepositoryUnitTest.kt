package com.sephoratest.network.products.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sephoratest.network.products.dtos.BrandDto
import com.sephoratest.network.products.dtos.ProductDto
import com.sephoratest.network.products.dtos.ProductImagesDto
import com.sephoratest.network.products.mappers.ApiProductMapper
import com.sephoratest.network.products.services.ProductsService
import com.sephoratest.network.util.exceptions.NetBadRequestException
import com.sephoratest.network.util.exceptions.NetInternalServerException
import com.sephoratest.network.util.exceptions.NetUnauthorizedException
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import retrofit2.Response
import retrofit2.mock.Calls

@OptIn(ExperimentalCoroutinesApi::class)
class ApiProductRepositoryUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val apiProductMapper = ApiProductMapper()

    private val service: ProductsService = mockk()
    private val productRepository = ApiProductRepository(service)

    private val products = listOf(
        ProductDto(
            id = 1461267310,
            name = "Size Up - Mascara Volume Extra Large Immédiat",
            description = "Craquez pour le Mascara Size Up de Sephora Collection : Volume XXL immédiat, cils ultra allongés et recourbés ★ Formule vegan longue tenue ✓",
            price = 140.00,
            images = ProductImagesDto(
                smallUrl = "https://dev.sephora.fr/on/demandware.static/-/Library-Sites-SephoraV2/default/dw521a3f33/brands/institbanner/SEPHO_900_280_institutional_banner_20210927_V2.jpg",
                largeUrl = ""
            ),
            brand = BrandDto(
                id = "SEPHO",
                name = "SEPHORA COLLECTION"
            ),
            isProductSet = false,
            isSpecialBrand = false,
        ),
        ProductDto(
            id = 1461267311,
            name = "Size Up - Mascara Volume Extra Large Immédiat",
            description = "Craquez pour le Mascara Size Up de Sephora Collection : Volume XXL immédiat, cils ultra allongés et recourbés ★ Formule vegan longue tenue ✓",
            price = 140.00,
            images = ProductImagesDto(
                smallUrl = "https://dev.sephora.fr/on/demandware.static/-/Library-Sites-SephoraV2/default/dw521a3f33/brands/institbanner/SEPHO_900_280_institutional_banner_20210927_V2.jpg",
                largeUrl = ""
            ),
            brand = BrandDto(
                id = "SEPHO",
                name = "SEPHORA COLLECTION"
            ),
            isProductSet = false,
            isSpecialBrand = false,
        ),
    )

    @Test
    fun shouldGetProducts() = runTest {
        val response = Calls.response(
            Response.success(products)
        )
        every { service.getAll() } returns response

        val result = productRepository.getAll()
            .getOrThrow()

        coVerify { service.getAll() }
        assert(result == products.map(apiProductMapper::from))
    }

    @Test
    fun shouldNotGetProductsWithBadRequest() = runTest {
        val response = Calls.failure<List<ProductDto>>(NetBadRequestException())
        every { service.getAll() } returns response

        try {
            productRepository.getAll()
                .getOrThrow()
            assert(false)
        } catch (e: NetBadRequestException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }
    }

    @Test
    fun shouldNotGetProductsWithInternalServerError() = runTest {
        val response = Calls.failure<List<ProductDto>>(NetInternalServerException())
        every { service.getAll() } returns response

        try {
            productRepository.getAll()
                .getOrThrow()
            assert(false)
        } catch (e: NetInternalServerException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }
    }

    @Test
    fun shouldNotGetProductsWithUnauthorized() = runTest {
        val response = Calls.failure<List<ProductDto>>(NetUnauthorizedException())
        every { service.getAll() } returns response

        try {
            productRepository.getAll()
                .getOrThrow()
            assert(false)
        } catch (e: NetUnauthorizedException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }
    }

}