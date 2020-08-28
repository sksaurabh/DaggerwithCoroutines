package com.saurabh.dagger2withcoroutines.data.services

import com.saurabh.dagger2withcoroutines.data.model.JokeListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RxApiService {
  @GET("/jokes/random/5") fun getFiveRandomJokes(): Single<JokeListResponse>
}