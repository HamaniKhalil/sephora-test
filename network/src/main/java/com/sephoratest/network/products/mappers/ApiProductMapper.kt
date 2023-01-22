package com.sephoratest.network.products.mappers

import com.sephoratest.core.util.ModelMapper
import com.sephoratest.domain.products.models.Product
import com.sephoratest.network.products.dtos.ProductDto

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class ApiProductMapper : ModelMapper<Product, ProductDto> {

    private val apiProductImagesMapper = ApiProductImagesMapper()
    private val apiBrandMapper = ApiBrandMapper()

    override fun to(product: Product): ProductDto =
        ProductDto(
            id = product.id,
            name = product.name,
            description = product.description,
            price = product.price,
            images = apiProductImagesMapper.to(product.images),
            brand = apiBrandMapper.to(product.brand),
            isProductSet = product.isProductSet,
            isSpecialBrand = product.isSpecialBrand,
        )

    override fun from(dto: ProductDto): Product =
        Product(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            price = dto.price,
            images = apiProductImagesMapper.from(dto.images),
            brand = apiBrandMapper.from(dto.brand),
            isProductSet = dto.isProductSet,
            isSpecialBrand = dto.isSpecialBrand,
        )
}