package com.saurabh.dagger2withcoroutines.data.services

import com.saurabh.dagger2withcoroutines.data.model.JokeListResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoroutineApiService {
  @GET("/jokes/random/5") suspend fun getFiveRandomJokes(): Response<JokeListResponse>
}