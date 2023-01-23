package com.sephoratest.app.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun ProductsScreen() {

    val viewModel: ProductsViewModel = viewModel()

    val isLoading by viewModel.isLoading.observeAsState()
    val products by viewModel.products.observeAsState()

    LaunchedEffect(true) {
        viewModel.loadAll()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = isLoading ?: false),
            onRefresh = { viewModel.loadAll() }) {

            LazyColumn {
                products?.let {
                    items(it) {
                        ProductListItem(it)
                    }
                }
            }
        }
    }

}