package com.mahi.kitmanlabs.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class AppPreferenceImpl(
  context: Context,
) : AppPreference {

  private var sharedPreferences: SharedPreferences =
    context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

  companion object {
    private const val IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN"
  }

  override var isUserLoggedIn: Boolean
    get() = sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false)
    set(value) {
      sharedPreferences.edit { putBoolean(IS_USER_LOGGED_IN, value) }
    }
}