package com.saurabh.dagger2withcoroutines.repo

import com.saurabh.dagger2withcoroutines.NetworkResult
import com.saurabh.dagger2withcoroutines.data.model.JokeListResponse
import com.saurabh.dagger2withcoroutines.data.services.CoroutineApiService

class JokeRepo constructor(private val coroutineApiService: CoroutineApiService) {

  suspend fun getFiveRandomJokes(): NetworkResult<JokeListResponse> {
    val response = coroutineApiService.getFiveRandomJokes()
    if (response.isSuccessful) {
      val data = response.body()
      if (data != null) {
        return NetworkResult.Success(data)
      }
    }
    return NetworkResult.Failure(response)
  }
}