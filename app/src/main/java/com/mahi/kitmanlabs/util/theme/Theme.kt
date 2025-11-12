package com.mahi.kitmanlabs.util.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
  primary = AppColors.blue,
  secondary = AppColors.red,
  tertiary = AppColors.black,
  background = AppColors.black
)

private val LightColorScheme = lightColorScheme(
  primary = AppColors.blue,
  secondary = AppColors.red,
  tertiary = AppColors.black,
  background = AppColors.black
)

@Composable
fun KitManLabsTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colorScheme = when {
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}