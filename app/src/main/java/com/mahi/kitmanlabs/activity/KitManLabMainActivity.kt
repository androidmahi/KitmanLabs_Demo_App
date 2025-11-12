package com.mahi.kitmanlabs.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mahi.kitmanlabs.data.local.pref.AppPreference
import com.mahi.kitmanlabs.navigation.KitManLabNavigationScreenContent
import com.mahi.kitmanlabs.util.theme.KitManLabsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject lateinit var appPreference: AppPreference

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      KitManLabsTheme {
        KitManLabNavigationScreenContent(
          isUserLoggedIn = appPreference.isUserLoggedIn
        )
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  KitManLabsTheme {
    Greeting("Android")
  }
}