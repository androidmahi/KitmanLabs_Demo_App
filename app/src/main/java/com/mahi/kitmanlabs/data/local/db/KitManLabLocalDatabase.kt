package com.mahi.kitmanlabs.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mahi.kitmanlabs.data.local.converter.KitManLabRoomTypeConverters
import com.mahi.kitmanlabs.data.local.dao.KitManLabDao
import com.mahi.kitmanlabs.data.local.entity.AthleteEntity
import com.mahi.kitmanlabs.data.local.entity.SquadEntity

@Database(
  entities = [
    AthleteEntity::class,
    SquadEntity::class
  ],
  version = 1
)
@TypeConverters(KitManLabRoomTypeConverters::class)
abstract class KitManLabLocalDatabase : RoomDatabase() {
  abstract fun kitManLabDao(): KitManLabDao
}