package com.app.architectureSample.common.network

class NetworkException(override val message: String, val errorCode: Int = 0) : Throwable() {
}