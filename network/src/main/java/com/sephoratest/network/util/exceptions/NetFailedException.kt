package com.sephoratest.network.util.exceptions

open class NetFailedException(
    override var message: String = MESSAGE
) : NetException(message) {
    companion object {
        const val MESSAGE = "Request failed for unknown reason"
    }
}