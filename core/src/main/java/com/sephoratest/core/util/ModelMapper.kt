package com.sephoratest.core.util

interface ModelMapper<Domain, Destination> {

    fun to(domain: Domain): Destination
    fun from(destination: Destination): Domain
}