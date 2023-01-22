package com.sephoratest.network.products.mappers

import com.sephoratest.core.util.ModelMapper
import com.sephoratest.domain.products.models.ProductImages
import com.sephoratest.network.products.dtos.ProductImagesDto

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class ApiProductImagesMapper : ModelMapper<ProductImages, ProductImagesDto>{

    override fun to(productImages: ProductImages): ProductImagesDto =
        ProductImagesDto(
            smallUrl = productImages.smallUrl,
            largeUrl = productImages.largeUrl,
        )

    override fun from(dto: ProductImagesDto): ProductImages =
        ProductImages(
            smallUrl = dto.smallUrl,
            largeUrl = dto.largeUrl,
        )

}