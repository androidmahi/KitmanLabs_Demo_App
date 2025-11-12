package com.mahi.kitmanlabs.screen.athlete.list.viewModel

import com.mahi.kitmanlabs.screen.athlete.list.uiModel.AthleteUiModel
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel

data class AthleteInfoUiState(
  val isLoading: Boolean = false,
  val athleteList: List<AthleteUiModel> = emptyList(),
  val squadDetailsMap: Map<Int, SquadUiModel> = emptyMap(),
  val toastMessage: String = "",
  val searchQuery: String = ""
)