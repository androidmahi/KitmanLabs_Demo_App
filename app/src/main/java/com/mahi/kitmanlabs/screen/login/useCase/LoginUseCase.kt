package com.mahi.kitmanlabs.screen.login.useCase

import com.mahi.kitmanlabs.data.local.pref.AppPreference
import com.mahi.kitmanlabs.repo.Repository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
  private val repository: Repository,
  private val appPreference: AppPreference
) {

  suspend operator fun invoke(
    username: String,
    password: String,
  ) {
    val isSuccess = repository.login(
      userName = username,
      password = password
    )

    appPreference.isUserLoggedIn = isSuccess
  }
}