package com.sephoratest.network.util.factories

import com.sephoratest.network.util.exceptions.*
import java.net.HttpURLConnection.*

object NetExceptionFactory {

    fun createFromHttpCode(httpCode: Int): NetException =
        when (httpCode) {
            HTTP_BAD_REQUEST -> NetBadRequestException()
            HTTP_UNAUTHORIZED -> NetUnauthorizedException()
            HTTP_INTERNAL_ERROR -> NetInternalServerException()
            else -> NetFailedException()
        }
}