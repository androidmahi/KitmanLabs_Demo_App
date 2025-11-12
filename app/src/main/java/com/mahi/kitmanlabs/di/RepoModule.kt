package com.mahi.kitmanlabs.di

import com.mahi.kitmanlabs.data.local.source.LocalDataSource
import com.mahi.kitmanlabs.data.remote.source.RemoteDataSource
import com.mahi.kitmanlabs.repo.Repository
import com.mahi.kitmanlabs.repo.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

  @Singleton
  @Provides
  fun providesRepository(
    localDataSource: LocalDataSource,
    remoteDataSource: RemoteDataSource,
  ): Repository {
    return RepositoryImpl(
      localDataSource = localDataSource,
      remoteDataSource = remoteDataSource
    )
  }
}