package com.sephoratest.di

import com.sephoratest.ui.mappers.UiProductMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UiModule {

    @Provides
    fun getUiProductMapper() =
        UiProductMapper()
}