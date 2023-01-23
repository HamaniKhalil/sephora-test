package com.sephoratest.app.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sephoratest.network.products.usecases.ApiGetAllProductsUseCase
import com.sephoratest.app.ui.mappers.UiProductMapper
import com.sephoratest.app.ui.models.UiProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    val apiGetAllProductsUseCase: ApiGetAllProductsUseCase,
    private val uiProductMapper: UiProductMapper,
) : ViewModel() {

    val isLoading = MutableLiveData(false)
    val products = MutableLiveData<List<UiProduct>>()

    fun loadAll() {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            apiGetAllProductsUseCase()
                .fold(
                    {
                        products.postValue(
                            it.map(uiProductMapper::to)
                        )
                        isLoading.postValue(false)
                    },
                    {
                        isLoading.postValue(false)
                        Log.d(TAG, "getAll: $it")
                    },
                )
        }
    }

    companion object {
        val TAG: String = ProductsViewModel::class.java.simpleName
    }
}