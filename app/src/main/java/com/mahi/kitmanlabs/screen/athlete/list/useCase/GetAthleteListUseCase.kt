package com.mahi.kitmanlabs.screen.athlete.list.useCase

import com.mahi.kitmanlabs.repo.Repository
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.AthleteUiModel
import javax.inject.Inject

class GetAthleteListUseCase @Inject constructor(
  private val repository: Repository,
) {

  suspend operator fun invoke(): List<AthleteUiModel> {
    return repository.getAthleteDetails()
  }
}