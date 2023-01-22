package com.sephoratest.network.util.exceptions

class NetUnauthorizedException(
    override var message: String = MESSAGE
) : NetException(message) {
    companion object {
        const val MESSAGE = "Server answered http unauthorized response"
    }
}