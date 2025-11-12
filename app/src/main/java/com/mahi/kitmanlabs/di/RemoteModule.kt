package com.mahi.kitmanlabs.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mahi.kitmanlabs.data.remote.source.RemoteDataSource
import com.mahi.kitmanlabs.data.remote.source.RetrofitDataSource
import com.mahi.kitmanlabs.data.remote.api.KitManLabApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

  private const val BASE_URL = "https://kitmanlabs.github.io/mobile-tech-challenge/api/"

  @Provides
  @Singleton
  fun provideJson(): Json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    prettyPrint = false
    encodeDefaults = true
  }

  @Provides
  @Singleton
  fun provideRetrofit(json: Json): Retrofit {

    val logger = HttpLoggingInterceptor()
      .apply {
        level = HttpLoggingInterceptor.Level.BODY
      }

    val okHttpClient = OkHttpClient.Builder()
      .addInterceptor(logger)
      .connectTimeout(30, TimeUnit.SECONDS)
      .readTimeout(30, TimeUnit.SECONDS)
      .writeTimeout(30, TimeUnit.SECONDS)
      .build()

    val contentType = "application/json".toMediaType()

    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(json.asConverterFactory(contentType))
      .build()
  }

  @Provides
  @Singleton
  fun provideApiService(retrofit: Retrofit): KitManLabApiService {
    return retrofit.create(KitManLabApiService::class.java)
  }

  @Provides
  @Singleton
  fun provideRemoteDataSource(apiService: KitManLabApiService): RemoteDataSource {
    return RetrofitDataSource(apiService)
  }
}