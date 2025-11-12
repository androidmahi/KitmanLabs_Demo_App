package com.mahi.kitmanlabs.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahi.kitmanlabs.screen.athlete.list.composable.AthleteListScreen
import com.mahi.kitmanlabs.screen.athlete.list.event.AthleteScreenEvent
import com.mahi.kitmanlabs.screen.athlete.list.viewModel.AthleteInfoViewModel
import com.mahi.kitmanlabs.screen.login.composable.LoginScreen
import com.mahi.kitmanlabs.screen.login.event.LoginEvent
import com.mahi.kitmanlabs.screen.login.viewModel.LoginViewModel
import com.mahi.kitmanlabs.screen.splash.composable.SplashScreen
import com.mahi.kitmanlabs.util.screen.ScreenRoutes

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun KitManLabNavigationScreenContent(
  modifier: Modifier = Modifier,
  isUserLoggedIn: Boolean,
  onClearLoggedInState: () -> Unit
) {
  val navController = rememberNavController()

  Scaffold { paddingValues ->
    NavHost(
      modifier = modifier
        .padding(paddingValues),
      navController = navController,
      startDestination = ScreenRoutes.SPLASH.route
    ) {

      composable(ScreenRoutes.SPLASH.route) {
        SplashScreen(
          onTimeOut = {
            val nextScreen = if (isUserLoggedIn) {
              ScreenRoutes.ATHLETE_LIST
            } else {
              ScreenRoutes.LOGIN
            }
            navController.navigate(nextScreen.route)
          }
        )
      }

      composable(ScreenRoutes.LOGIN.route) {

        val viewModel: LoginViewModel = hiltViewModel()

        val uiState = viewModel.state.collectAsStateWithLifecycle().value

        LoginScreen(
          uiState = uiState,
          onEvent = { event ->
            when (event) {
              is LoginEvent.OnUserNameUpdated -> {
                viewModel.updateUserName(event.username)
              }

              is LoginEvent.OnPasswordUpdated -> {
                viewModel.updatePassword(event.password)
              }

              LoginEvent.OnLoginClicked -> viewModel.loginUser()

              LoginEvent.ClearToastMessage -> viewModel.updateToastMessage("")
              LoginEvent.OnLoginSuccess -> {
                navController.navigate(ScreenRoutes.ATHLETE_LIST.route)
              }
            }
          }

        )
      }

      composable(ScreenRoutes.ATHLETE_LIST.route) {

        val viewModel: AthleteInfoViewModel = hiltViewModel()

        val uiState = viewModel.state.collectAsStateWithLifecycle().value

        AthleteListScreen(
          uiState = uiState,
          onEvent = { event ->
            when(event) {
              AthleteScreenEvent.OnFetchInitialData -> {
                viewModel.getAthleteListAndSquadDetails()
              }
              is AthleteScreenEvent.OnSearchQueryUpdated -> {
                viewModel.updateSearchQuery(event.query)
              }

              AthleteScreenEvent.OnLogoutClicked -> {
                onClearLoggedInState()
                navController.navigate(ScreenRoutes.LOGIN.route) {
                  popUpTo(0) { inclusive = true }
                  launchSingleTop = true
                }
              }
            }
          }
        )

      }

      composable(ScreenRoutes.ATHLETE_DETAIL.route) {

      }

    }
  }
}