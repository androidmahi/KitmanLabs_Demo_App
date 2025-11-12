package com.mahi.kitmanlabs.screen.login.event

sealed class LoginEvent {
  data class OnUserNameUpdated(val username: String) : LoginEvent()
  data class OnPasswordUpdated(val password: String) : LoginEvent()
  object OnLoginClicked : LoginEvent()
  object ClearToastMessage : LoginEvent()
  object OnLoginSuccess : LoginEvent()
}