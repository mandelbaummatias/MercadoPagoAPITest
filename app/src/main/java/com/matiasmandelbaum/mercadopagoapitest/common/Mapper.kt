package com.matiasmandelbaum.mercadopagoapitest.common

interface Mapper<F, T> {
    fun mapFrom(from: F): T
}