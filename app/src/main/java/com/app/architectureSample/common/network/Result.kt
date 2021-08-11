package com.app.architectureSample.common.network

sealed class Result<out R> {

    // object isInProgress : Result<Nothing>()

    data class Success<out R>(val networkResponse: NetworkResponse<R>) : Result<R>()

    data class Error(val networkException: NetworkException) : Result<Nothing>()
}
