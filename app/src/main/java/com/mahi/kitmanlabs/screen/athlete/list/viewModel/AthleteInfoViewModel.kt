package com.mahi.kitmanlabs.screen.athlete.list.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.AthleteUiModel
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel
import com.mahi.kitmanlabs.screen.athlete.list.useCase.GetAthleteListUseCase
import com.mahi.kitmanlabs.screen.athlete.list.useCase.GetSquadDetailsUseCase
import com.mahi.kitmanlabs.util.ext.getErrorMessage
import com.mahi.kitmanlabs.util.ext.launchWithHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AthleteInfoViewModel @Inject constructor(
  private val getAthleteListUseCase: GetAthleteListUseCase,
  private val getSquadDetailsUseCase: GetSquadDetailsUseCase,
) : ViewModel() {

  init {
    getAthleteListAndSquadDetails()
  }

  private val _state = MutableStateFlow(AthleteInfoUiState())
  val state = _state.asStateFlow()

  fun getAthleteListAndSquadDetails() {
    viewModelScope.launchWithHandler(
      onCoroutineException = {
        hideLoader()
        updateToastMessage(it.getErrorMessage())
      }
    ) {

      showLoader()

      val squadUiModelsMap = getSquadDetailsUseCase.invoke()
      updateSquadDetailsMap(squadUiModelsMap)

      val athleteUiModels = getAthleteListUseCase.invoke()
      updateAthleteList(athleteUiModels)

      hideLoader()
    }
  }

  fun showLoader() {
    _state.update { it.copy(isLoading = true) }
  }

  fun hideLoader() {
    _state.update { it.copy(isLoading = false) }
  }

  fun updateAthleteList(athletes: List<AthleteUiModel>) {
    _state.update { it.copy(athleteList = athletes) }
  }

  fun updateSquadDetailsMap(map: Map<Int, SquadUiModel>) {
    _state.update { it.copy(squadDetailsMap = map) }
  }

  fun updateToastMessage(message: String) {
    _state.update { it.copy(toastMessage = message) }
  }

  fun updateSearchQuery(query: String) {
    _state.update { it.copy(searchQuery = query) }
  }
}