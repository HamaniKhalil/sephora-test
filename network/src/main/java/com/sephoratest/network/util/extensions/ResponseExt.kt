package com.sephoratest.network.util.extensions

import com.sephoratest.network.util.exceptions.NetNullBodyException
import com.sephoratest.network.util.factories.NetExceptionFactory
import retrofit2.Response
import java.net.HttpURLConnection

fun <T> Response<T>.handle() =
    when (code()) {
        HttpURLConnection.HTTP_OK -> body() ?: throw NetNullBodyException()
        else ->
            throw NetExceptionFactory
                .createFromHttpCode(code())
    }