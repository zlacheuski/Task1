package com.example.task1.data.repository

import com.example.task1.tools.Constants

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Empty<T>(val status: String = Constants.EMPTY_RESPONSE) : Resource<T>()
    data class Error<T>(val errMessage: String) : Resource<T>()
    data class Progress<T>(val status: String = Constants.IN_PROGRESS_RESPONSE) : Resource<T>()
}