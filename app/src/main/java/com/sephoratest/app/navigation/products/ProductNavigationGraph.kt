package com.sephoratest.app.navigation.products

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sephoratest.app.products.detail.ProductDetailScreen
import com.sephoratest.app.products.list.ProductsScreen
import com.sephoratest.app.ui.models.UiProduct

@Composable
fun ProductNavigationGraph(
    modifier: Modifier,
    navigationController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navigationController,
        startDestination = ProductNavigationItem.ProductList.route
    ) {
        composable(ProductNavigationItem.ProductList.route) {
            ProductsScreen(
                onProductClicked = { product ->
                    it.savedStateHandle.set(
                        key = "product",
                        value = product
                    )
                    navigationController.navigate(
                        ProductNavigationItem.ProductDetail.route
                    )
                }
            )
        }
        composable(ProductNavigationItem.ProductDetail.route) {
            navigationController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<UiProduct>("product")
                ?.let { uiProduct ->
                    ProductDetailScreen(
                        product = uiProduct,
                        onBackClicked = { navigationController.popBackStack() }
                    )
                }
        }
    }
}