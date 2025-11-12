package com.mahi.kitmanlabs.screen.login.viewModel

data class LoginUiState(
  val userName: String = "",
  val password: String = "",
  val isLoginSuccess: Boolean = false,
  val toastMessage: String = "",
  val isLoading: Boolean = false
)