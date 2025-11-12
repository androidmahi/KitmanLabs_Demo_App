package com.mahi.kitmanlabs.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahi.kitmanlabs.data.local.entity.AthleteEntity
import com.mahi.kitmanlabs.data.local.entity.SquadEntity

@Dao
interface KitManLabDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAthleteList(athleteList: List<AthleteEntity>)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertSquadList(squadList: List<SquadEntity>)

  @Query("SELECT * FROM athlete_details")
  fun getLocalAthleteList(): List<AthleteEntity>

  @Query("SELECT * FROM squad_details")
  fun getLocalSquadList(): List<SquadEntity>

}