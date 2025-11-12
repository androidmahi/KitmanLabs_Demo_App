package com.mahi.kitmanlabs.data.remote.dto

import com.mahi.kitmanlabs.data.local.entity.AthleteEntity
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.AthleteUiModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AthleteDTO(
  val id: Int,

  @SerialName("first_name")
  val firstName: String,

  @SerialName("last_name")
  val lastName: String,

  @SerialName("image")
  val image: AthleteImage,

  @SerialName("username")
  val userName: String,

  @SerialName("squad_ids")
  val squadIds: List<Int>,
)

@Serializable
data class AthleteImage(
  val url: String,
)

fun AthleteDTO.toEntity() = AthleteEntity(
  id = id,
  firstName = firstName,
  lastName = lastName,
  imageUrl = image.url,
  userName = userName,
  squadIds = squadIds
)

fun Iterable<AthleteDTO>.toEntities() = this.map { it.toEntity() }
