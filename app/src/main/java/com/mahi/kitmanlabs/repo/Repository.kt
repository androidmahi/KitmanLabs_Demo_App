package com.mahi.kitmanlabs.repo

import com.mahi.kitmanlabs.screen.athlete.list.uiModel.AthleteUiModel
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel

interface Repository {

  suspend fun login(userName: String, password: String): Boolean

  suspend fun getAthleteDetails(): List<AthleteUiModel>

  suspend fun getSquadDetails(): List<SquadUiModel>
}