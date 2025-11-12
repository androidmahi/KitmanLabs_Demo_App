package com.mahi.kitmanlabs.screen.athlete.list.useCase

import com.mahi.kitmanlabs.repo.Repository
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.AthleteUiModel
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel
import javax.inject.Inject

class GetSquadDetailsUseCase @Inject constructor(
  private val repository: Repository,
) {
  suspend operator fun invoke(): Map<Int, SquadUiModel> {
    val detailMap = repository.getSquadDetails()
      .associateBy { it.id }
    return detailMap
  }
}