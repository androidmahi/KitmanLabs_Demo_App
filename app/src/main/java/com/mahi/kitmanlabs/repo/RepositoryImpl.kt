package com.mahi.kitmanlabs.repo

import com.mahi.kitmanlabs.data.local.entity.toUiModels
import com.mahi.kitmanlabs.data.local.source.LocalDataSource
import com.mahi.kitmanlabs.data.remote.dto.toEntities
import com.mahi.kitmanlabs.data.remote.source.RemoteDataSource
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.AthleteUiModel
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel

class RepositoryImpl(
  private val localDataSource: LocalDataSource,
  private val remoteDataSource: RemoteDataSource,
) : Repository {

  override suspend fun login(userName: String, password: String): Boolean {
    val isSuccess = remoteDataSource.login(
      userName = userName,
      password = password
    )
    return isSuccess
  }

  override suspend fun getAthleteDetails(): List<AthleteUiModel> {
    val existingLocalAthleteList = localDataSource.getAthleteDetailsFromCache()

    if (existingLocalAthleteList.isNotEmpty()) {
      return existingLocalAthleteList.toUiModels()
    }

    val remoteAthleteList = remoteDataSource.getAthleteDetailsFromOnline()

    val freshLocalAthletesList = remoteAthleteList.toEntities()
    localDataSource.saveAthleteListToCache(freshLocalAthletesList)

    return freshLocalAthletesList.toUiModels()
  }

  override suspend fun getSquadDetails(): List<SquadUiModel> {
    val existingLocalSquadList = localDataSource.getSquadDetailsFromCache()

    if (existingLocalSquadList.isNotEmpty()) {
      return existingLocalSquadList.toUiModels()
    }

    val remoteSquadList = remoteDataSource.getSquadDetailsFromOnline()

    val freshLocalSquadList = remoteSquadList.toEntities()
    localDataSource.saveSquadListToCache(freshLocalSquadList)

    return freshLocalSquadList.toUiModels()
  }
}