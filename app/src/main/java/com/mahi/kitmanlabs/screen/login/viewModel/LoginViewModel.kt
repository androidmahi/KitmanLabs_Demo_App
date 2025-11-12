package com.mahi.kitmanlabs.screen.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahi.kitmanlabs.data.local.pref.AppPreference
import com.mahi.kitmanlabs.repo.Repository
import com.mahi.kitmanlabs.screen.login.useCase.LoginUseCase
import com.mahi.kitmanlabs.util.ext.getErrorMessage
import com.mahi.kitmanlabs.util.ext.launchWithHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val loginUseCase: LoginUseCase,
  private val appPreference: AppPreference
) : ViewModel() {

  private val _state = MutableStateFlow(LoginUiState())
  val state = _state.asStateFlow()

  fun updateUserName(name: String) {
    _state.update { it.copy(userName = name) }
  }

  fun updatePassword(pass: String) {
    _state.update { it.copy(password = pass) }
  }

  fun loginUser() {
    if (isUserInputValid().not()) return

    viewModelScope.launchWithHandler(
      onCoroutineException = {
        hideLoader()
        updateToastMessage(it.getErrorMessage())
      }
    ) {
      showLoader()

      val state = _state.value

      loginUseCase.invoke(
        username = state.userName,
        password = state.password
      )

      delay(50)

      updateIsLoginSuccess(appPreference.isUserLoggedIn)

      hideLoader()
    }
  }

  fun isUserInputValid(): Boolean {

    val state = _state.value

    if (state.userName.isEmpty()) {
      updateToastMessage("Enter Username")
      return false
    }

    if (state.userName.length < 3) {
      updateToastMessage("Give full Username")
      return false
    }

    if (state.password.isEmpty()) {
      updateToastMessage("Enter Password")
      return false
    }

    if (state.password.length < 3) {
      updateToastMessage("Give full Password")
      return false
    }

    return true
  }

  fun updateIsLoginSuccess(success: Boolean) {
    _state.update { it.copy(isLoginSuccess = success) }
  }

  fun updateToastMessage(message: String) {
    _state.update { it.copy(toastMessage = message) }
  }

  fun showLoader() {
    _state.update { it.copy(isLoading = true) }
  }

  fun hideLoader() {
    _state.update { it.copy(isLoading = false) }
  }
}