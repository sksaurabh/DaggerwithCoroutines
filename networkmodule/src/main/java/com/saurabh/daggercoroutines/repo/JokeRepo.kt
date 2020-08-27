package com.saurabh.daggercoroutines.repo

import com.saurabh.daggercoroutines.NetworkResult
import com.saurabh.daggercoroutines.data.model.JokeListResponse
import com.saurabh.daggercoroutines.data.services.CoroutineApiService

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