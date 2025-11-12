package com.mahi.kitmanlabs.data.remote.source

import com.mahi.kitmanlabs.data.remote.api.KitManLabApiService
import com.mahi.kitmanlabs.data.remote.dto.AthleteDTO
import com.mahi.kitmanlabs.data.remote.dto.SquadDTO
import com.mahi.kitmanlabs.util.constant.Constants

class RetrofitDataSource(
  private val apiService: KitManLabApiService,
) : RemoteDataSource {

  override suspend fun login(userName: String, password: String): Boolean {
    // as of now we are using the test endPoint with no param
    try {
      val response = apiService.getLoginStatus()
      return response.status == Constants.LOGIN_SUCCESS_MESSAGE
    } catch (e: Exception) {
      throw e
    }
  }

  override suspend fun getAthleteDetailsFromOnline(): List<AthleteDTO> {
    try {
      val response = apiService.getAthleteDetails()
      return response
    } catch (e: Exception) {
      throw e
    }
  }

  override suspend fun getSquadDetailsFromOnline(): List<SquadDTO> {
    try {
      val response = apiService.getSquadDetails()
      return response
    } catch (e: Exception) {
      throw e
    }
  }


}