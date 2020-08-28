package com.saurabh.dagger2withcoroutines

import retrofit2.Response

sealed class NetworkResult<out T> {
  data class Success<T>(val body: T) : NetworkResult<T>()
  data class Failure<T>(val errorResponse: Response<T>? = null) : NetworkResult<T>()
}