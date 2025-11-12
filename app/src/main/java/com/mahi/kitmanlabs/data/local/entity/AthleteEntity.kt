package com.mahi.kitmanlabs.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.AthleteUiModel

@Entity(tableName = "athlete_details")
data class AthleteEntity(
  @PrimaryKey
  val id: Int,
  val firstName: String,
  val lastName: String,
  val imageUrl: String,
  val userName: String,
  val squadIds: List<Int>,
)

fun AthleteEntity.toUiModel() = AthleteUiModel(
  id = id,
  firstName = firstName,
  lastName = lastName,
  imageUrl = imageUrl,
  userName = userName,
  squadIds = squadIds
)

fun Iterable<AthleteEntity>.toUiModels() = this.map { it.toUiModel() }