package com.mahi.kitmanlabs.data.remote.api

import com.mahi.kitmanlabs.data.remote.dto.AthleteDTO
import com.mahi.kitmanlabs.data.remote.dto.LoginResponseDTO
import com.mahi.kitmanlabs.data.remote.dto.SquadDTO
import retrofit2.http.GET

interface KitManLabApiService {

  @GET("session.json")
  suspend fun getLoginStatus(): LoginResponseDTO

  @GET("athletes.json")
  suspend fun getAthleteDetails(): List<AthleteDTO>

  @GET("squads.json")
  suspend fun getSquadDetails(): List<SquadDTO>

}