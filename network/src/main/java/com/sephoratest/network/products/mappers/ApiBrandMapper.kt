package com.sephoratest.network.products.mappers

import com.sephoratest.core.util.ModelMapper
import com.sephoratest.domain.products.models.Brand
import com.sephoratest.network.products.dtos.BrandDto

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class ApiBrandMapper : ModelMapper<Brand, BrandDto>{

    override fun to(brand: Brand): BrandDto =
        BrandDto(
            id = brand.id,
            name = brand.name,
        )

    override fun from(dto: BrandDto): Brand =
        Brand(
            id = dto.id,
            name = dto.name,
        )
}