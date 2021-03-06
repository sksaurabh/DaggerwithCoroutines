package com.saurabh.dagger2withcoroutines.injection.module

import com.saurabh.dagger2withcoroutines.AppConstants
import com.saurabh.dagger2withcoroutines.BuildConfig
import com.saurabh.dagger2withcoroutines.data.services.CoroutineApiService
import com.saurabh.dagger2withcoroutines.data.services.RxApiService
import com.saurabh.dagger2withcoroutines.repo.JokeRepo
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

  @Provides @Singleton internal fun provideOkHttpClient(): OkHttpClient {
    val httpBuilder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
      val httpLoggingInterceptor = HttpLoggingInterceptor()
      httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
      httpBuilder.interceptors()
          .add(httpLoggingInterceptor)
    }
    return httpBuilder.build()
  }

  @Provides @Singleton @Named(AppConstants.COROUTINE_RETROFIT) internal fun provideCoroutineRestAdapter(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
  }

  @Provides @Singleton internal fun provideCoroutineApiService( @Named(AppConstants.COROUTINE_RETROFIT) restAdapter: Retrofit): CoroutineApiService {
    return restAdapter.create(CoroutineApiService::class.java)
  }

  @Provides @Singleton internal fun provideCoroutineJokeRepo(coroutineApiService: CoroutineApiService): JokeRepo {
    return JokeRepo(coroutineApiService)
  }

  @Provides @Singleton @Named(AppConstants.RX_RETROFIT) internal fun provideRxRestAdapter(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
  }

  @Provides @Singleton internal fun provideRxApiService( @Named(AppConstants.RX_RETROFIT) restAdapter: Retrofit): RxApiService {
    return restAdapter.create(RxApiService::class.java)
  }
}
