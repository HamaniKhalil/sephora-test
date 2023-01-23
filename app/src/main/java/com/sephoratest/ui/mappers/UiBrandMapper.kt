package com.sephoratest.ui.mappers

import com.sephoratest.core.util.ModelMapper
import com.sephoratest.domain.products.models.Brand
import com.sephoratest.ui.models.UiBrand

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class UiBrandMapper : ModelMapper<Brand, UiBrand> {

    override fun to(brand: Brand): UiBrand =
        UiBrand(
            id = brand.id,
            name = brand.name,
        )

    override fun from(ui: UiBrand): Brand =
        Brand(
            id = ui.id,
            name = ui.name,
        )
}