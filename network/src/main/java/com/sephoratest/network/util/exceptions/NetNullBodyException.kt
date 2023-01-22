package com.sephoratest.network.util.exceptions

class NetNullBodyException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "The network result should not be null"
    }
}