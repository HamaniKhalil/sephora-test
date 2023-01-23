package com.sephoratest.app.navigation.products

sealed class ProductNavigationItem(
    val route: String
) {

    object ProductList : ProductNavigationItem(route = "product-list")
    object ProductDetail : ProductNavigationItem(route = "product-detail")
}
