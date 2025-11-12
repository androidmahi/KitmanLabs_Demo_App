package com.mahi.kitmanlabs.data.local.source

import com.mahi.kitmanlabs.data.local.entity.AthleteEntity
import com.mahi.kitmanlabs.data.local.entity.SquadEntity

interface LocalDataSource {

  fun getAthleteDetailsFromCache(): List<AthleteEntity>

  fun getSquadDetailsFromCache(): List<SquadEntity>

  fun saveAthleteListToCache(athletes: List<AthleteEntity>)

  fun saveSquadListToCache(squads: List<SquadEntity>)

}