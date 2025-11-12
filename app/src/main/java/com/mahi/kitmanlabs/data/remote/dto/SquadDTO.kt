package com.mahi.kitmanlabs.data.remote.dto

import com.mahi.kitmanlabs.data.local.entity.SquadEntity
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SquadDTO(
  val id: Int,
  val name: String,
  @SerialName("organisation_id")
  val orgId: Int,
  @SerialName("created_at")
  val createdAt: String,
  @SerialName("updated_at")
  val updatedAt: String
)

fun SquadDTO.toEntity() = SquadEntity(
  id = id,
  name = name,
  orgId = orgId,
  createdAt = createdAt,
  updatedAt = updatedAt
)

fun Iterable<SquadDTO>.toEntities() = this.map { it.toEntity() }
