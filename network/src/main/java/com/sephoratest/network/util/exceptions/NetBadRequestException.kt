package com.sephoratest.network.util.exceptions

class NetBadRequestException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "Server answered http bad request"
    }
}