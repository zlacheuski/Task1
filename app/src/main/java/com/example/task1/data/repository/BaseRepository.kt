package com.example.task1.data.repository

import com.example.task1.tools.Constants
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

open class BaseRepository {

    open suspend fun <T> callOrError(response: Response<T>): Flow<Resource<T>> = flow {
        try {
            response.body()?.let { body ->
                emit(Resource.Success(body))
            } ?: when (response.code()) {
                200 -> emit(Resource.Empty(Constants.EMPTY_RESPONSE))
                else -> emit(Resource.Error(getErrorMessage(response)))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.stackTraceToString()))
        }
    }

    private fun <T> getErrorMessage(resp: Response<T>): String = Gson().fromJson(
        resp.errorBody()?.string(),
        String::class.java
    )
}
