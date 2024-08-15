package com.example.tastetributes.utils

sealed class Resource <T> (val status: Status, val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resource<T>(status = Status.Success, data = data)
    class Error<T>(message: String?): Resource<T>(status = Status.Error, message = message)
}

enum class Status {
    Success, Error
}