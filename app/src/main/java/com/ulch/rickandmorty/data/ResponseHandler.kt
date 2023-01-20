package com.ulch.rickandmorty.data

import retrofit2.Response


class ResponseHandler {
    fun <T> handleSuccess(data: T): ResponseWrapper<T> {
        return ResponseWrapper(data = data)
    }

    fun <T> handleException(error: String?, code: Int? = null): ResponseWrapper<T> {
        return ResponseWrapper(error = error, code = code)
    }
}

fun <T> Response<T>.handle(): ResponseWrapper<T> {
    return if (this.isSuccessful && this.body() != null) {
        ResponseHandler().handleSuccess(this.body()!!)
    } else {
        ResponseHandler().handleException(this.errorBody()?.string(), this.code())
    }
}