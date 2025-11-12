package com.mahi.kitmanlabs.screen.login.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mahi.kitmanlabs.screen.login.component.LoginButton
import com.mahi.kitmanlabs.screen.login.component.LoginInputFieldType
import com.mahi.kitmanlabs.screen.login.component.TitleBanner
import com.mahi.kitmanlabs.screen.login.event.LoginEvent
import com.mahi.kitmanlabs.screen.login.viewModel.LoginUiState
import com.mahi.kitmanlabs.util.compose.FillSpacer
import com.mahi.kitmanlabs.util.compose.HandleToastMessage
import com.mahi.kitmanlabs.util.compose.VerticalSpacer
import com.mahi.kitmanlabs.util.theme.AppColors

@Composable
fun LoginScreen(
  modifier: Modifier = Modifier,
  uiState: LoginUiState,
  onEvent: (LoginEvent) -> Unit,
) {

  HandleToastMessage(toastMessage = uiState.toastMessage) {
    onEvent.invoke(LoginEvent.ClearToastMessage)
  }

  LaunchedEffect(uiState.isLoginSuccess) {
    if (uiState.isLoginSuccess) {
      onEvent.invoke(LoginEvent.OnLoginSuccess)
    }
  }

  Column(
    modifier = modifier
      .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {

    VerticalSpacer(15)

    TitleBanner(
      //needs to be extracted as string resource
      title = "Welcome to KitManLabs"
    )

    VerticalSpacer(30)

    FillSpacer()

    Text(
      text = "Please Enter Your \n\n Credentials".uppercase(),
      fontWeight = FontWeight.ExtraBold,
      color = AppColors.white,
      fontSize = 28.sp,
      lineHeight = 28.sp,
      textAlign = TextAlign.Center
    )

    VerticalSpacer(20)

    LoginInputFieldType(
      label = "UserName",
      value = uiState.userName,
      onValueChange = {
        onEvent.invoke(LoginEvent.OnUserNameUpdated(it))
      }
    )

    VerticalSpacer(15)

    LoginInputFieldType(
      label = "PassWord",
      value = uiState.password,
      onValueChange = {
        onEvent.invoke(LoginEvent.OnPasswordUpdated(it))
      }
    )

    VerticalSpacer(25)

    if (uiState.isLoading) {
      CircularProgressIndicator(
        color = AppColors.red
      )
    } else {
      LoginButton(
        title = "Login",
        onClick = {
          onEvent(LoginEvent.OnLoginClicked)
        }
      )
    }

    VerticalSpacer(20)

    FillSpacer()

  }
}