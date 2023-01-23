package com.sephoratest.app.di

import com.sephoratest.app.products.list.ProductsViewModel
import com.sephoratest.app.ui.mappers.UiProductMapper
import com.sephoratest.network.products.usecases.ApiGetAllProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ViewModelsModule {

    @Provides
    fun getProductsListViewModel(
        apiGetAllProductsUseCase: ApiGetAllProductsUseCase,
        uiProductMapper: UiProductMapper
    ) = ProductsViewModel(
        apiGetAllProductsUseCase,
        uiProductMapper
    )
}