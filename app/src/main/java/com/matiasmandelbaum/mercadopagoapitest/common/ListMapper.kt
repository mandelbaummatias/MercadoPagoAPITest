package com.matiasmandelbaum.mercadopagoapitest.common

interface ListMapper<F, T> {
    fun mapList(from: List<F>): List<T>
}