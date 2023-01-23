package com.sephoratest.ui.mappers

import com.sephoratest.core.util.ModelMapper
import com.sephoratest.domain.products.models.ProductImages
import com.sephoratest.ui.models.UiProductImages

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class UiProductImagesMapper : ModelMapper<ProductImages, UiProductImages> {

    override fun to(productImages: ProductImages): UiProductImages =
        UiProductImages(
            smallUrl = productImages.smallUrl,
            largeUrl = productImages.largeUrl,
        )

    override fun from(ui: UiProductImages): ProductImages =
        ProductImages(
            smallUrl = ui.smallUrl,
            largeUrl = ui.largeUrl,
        )
}