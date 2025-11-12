package com.mahi.kitmanlabs.screen.athlete.list.event

sealed class AthleteScreenEvent {
  object OnFetchInitialData : AthleteScreenEvent()
  data class OnSearchQueryUpdated(val query: String) : AthleteScreenEvent()
}
