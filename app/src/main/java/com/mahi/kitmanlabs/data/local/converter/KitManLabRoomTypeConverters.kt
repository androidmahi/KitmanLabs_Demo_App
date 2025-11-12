package com.mahi.kitmanlabs.data.local.converter

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json

class KitManLabRoomTypeConverters() {

  private val json = Json

  @TypeConverter
  fun fromSquadList(squads: List<Int>): String {
    return json.encodeToString(squads)
  }

  @TypeConverter
  fun toSquadList(squadJson: String): List<Int> {
    return json.decodeFromString<List<Int>>(squadJson)
  }

}