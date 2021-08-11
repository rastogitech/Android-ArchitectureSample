package com.app.architectureSample.common.network

import okhttp3.Headers

data class NetworkResponse<out R>(
    val data: R?,
    val statusCode: Int = 0,
    val responseHeaders: Headers? = null
)