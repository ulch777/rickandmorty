package com.ulch.rickandmorty.data

data class ResponseWrapper<T>(
    val data: T? = null,
    val error: String? = null,
    val code: Int? = null
)