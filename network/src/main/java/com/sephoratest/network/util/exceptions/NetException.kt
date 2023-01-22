package com.sephoratest.network.util.exceptions


abstract class NetException(
    override var message: String
) : Exception(message)