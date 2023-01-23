package com.sephoratest.di

import com.sephoratest.network.BASE_URL
import com.sephoratest.network.products.repositories.ApiProductRepository
import com.sephoratest.network.products.services.ProductsService
import com.sephoratest.network.products.usecases.ApiGetAllProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Okhttp
     */

    // Logger
    @Provides
    fun getHttpLogger() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }


    @Provides
    fun getOkhttpClient(logger: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

    @Provides
    fun getGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    fun getProductService(
        gsonConverterFactory: GsonConverterFactory,
        client: OkHttpClient
    ): ProductsService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .build()
            .create(ProductsService::class.java)

    @Provides
    fun getProductRepository(service: ProductsService) =
        ApiProductRepository(service)

    @Provides
    fun getAllProductsApiUseCase(repository: ApiProductRepository) =
        ApiGetAllProductsUseCase(repository)
}
