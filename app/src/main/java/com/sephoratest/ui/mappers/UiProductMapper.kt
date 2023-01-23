package com.sephoratest.ui.mappers

import com.sephoratest.core.util.ModelMapper
import com.sephoratest.domain.products.models.Product
import com.sephoratest.ui.models.UiProduct

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class UiProductMapper : ModelMapper<Product, UiProduct> {

    private val uiProductImagesMapper = UiProductImagesMapper()
    private val uiBrandMapper = UiBrandMapper()

    override fun to(product: Product): UiProduct =
        UiProduct(
            id = product.id,
            name = product.name,
            description = product.description,
            price = product.price,
            images = uiProductImagesMapper.to(product.images),
            brand = uiBrandMapper.to(product.brand),
            isProductSet = product.isProductSet,
            isSpecialBrand = product.isSpecialBrand,
        )

    override fun from(ui: UiProduct): Product =
        Product(
            id = ui.id,
            name = ui.name,
            description = ui.description,
            price = ui.price,
            images = uiProductImagesMapper.from(ui.images),
            brand = uiBrandMapper.from(ui.brand),
            isProductSet = ui.isProductSet,
            isSpecialBrand = ui.isSpecialBrand,
        )
}