package com.sephoratest.network.util.exceptions

class NetInternalServerException(
    override var message: String = MESSAGE
) : NetException(message) {
    companion object {
        const val MESSAGE = "Server answered http internal error"
    }
}