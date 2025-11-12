package com.mahi.kitmanlabs.data.local.source

import com.mahi.kitmanlabs.data.local.dao.KitManLabDao
import com.mahi.kitmanlabs.data.local.entity.AthleteEntity
import com.mahi.kitmanlabs.data.local.entity.SquadEntity

class RoomDataSource(
  private val dao: KitManLabDao
): LocalDataSource {

  override fun getAthleteDetailsFromCache(): List<AthleteEntity> {
    return dao.getLocalAthleteList()
  }

  override fun getSquadDetailsFromCache(): List<SquadEntity> {
    return dao.getLocalSquadList()
  }

  override fun saveAthleteListToCache(athletes: List<AthleteEntity>) {
    dao.insertAthleteList(athletes)
  }

  override fun saveSquadListToCache(squads: List<SquadEntity>) {
    dao.insertSquadList(squads)
  }

}