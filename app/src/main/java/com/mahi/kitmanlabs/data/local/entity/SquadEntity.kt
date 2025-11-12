package com.mahi.kitmanlabs.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel

@Entity(tableName = "squad_details")
data class SquadEntity(
  @PrimaryKey
  val id: Int,
  val name: String,
  val orgId: Int,
  val createdAt: String,
  val updatedAt: String
)

fun SquadEntity.toUiModel() = SquadUiModel(
  id = id,
  name = name,
  orgId = orgId,
  createdAt = createdAt,
  updatedAt = updatedAt
)

fun Iterable<SquadEntity>.toUiModels() = this.map { it.toUiModel() }