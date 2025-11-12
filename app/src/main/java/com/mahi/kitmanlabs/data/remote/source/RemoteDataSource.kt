package com.mahi.kitmanlabs.data.remote.source

import com.mahi.kitmanlabs.data.remote.dto.AthleteDTO
import com.mahi.kitmanlabs.data.remote.dto.SquadDTO

interface RemoteDataSource {

  suspend fun login(userName: String, password: String): Boolean

  suspend fun getAthleteDetailsFromOnline(): List<AthleteDTO>

  suspend fun getSquadDetailsFromOnline(): List<SquadDTO>
}