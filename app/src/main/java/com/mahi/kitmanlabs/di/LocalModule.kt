package com.mahi.kitmanlabs.di

import android.content.Context
import androidx.room.Room
import com.mahi.kitmanlabs.data.local.dao.KitManLabDao
import com.mahi.kitmanlabs.data.local.db.KitManLabLocalDatabase
import com.mahi.kitmanlabs.data.local.pref.AppPreference
import com.mahi.kitmanlabs.data.local.pref.AppPreferenceImpl
import com.mahi.kitmanlabs.data.local.source.LocalDataSource
import com.mahi.kitmanlabs.data.local.source.RoomDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

  @Provides
  @Singleton
  fun providesRoomDB(
    @ApplicationContext context: Context,
  ): KitManLabLocalDatabase {
    val localDB = Room.databaseBuilder(
      context,
      KitManLabLocalDatabase::class.java,
      "KitManLabs_LocalDB"
    )
      .build()
    return localDB
  }

  @Provides
  @Singleton
  fun providesRoomDao(
    db: KitManLabLocalDatabase,
  ): KitManLabDao {
    return db.kitManLabDao()
  }

  @Provides
  @Singleton
  fun provideLocalDataSource(
    dao: KitManLabDao,
  ): LocalDataSource {
    return RoomDataSource(dao)
  }

  @Provides
  @Singleton
  fun provideAppPreferences(
    @ApplicationContext context: Context,
  ): AppPreference {
    return AppPreferenceImpl(context)
  }
}