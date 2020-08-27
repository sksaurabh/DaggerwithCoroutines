package com.saurabh.daggercoroutines.data.services

import com.saurabh.daggercoroutines.data.model.JokeListResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoroutineApiService {
  @GET("/jokes/random/5") suspend fun getFiveRandomJokes(): Response<JokeListResponse>
}