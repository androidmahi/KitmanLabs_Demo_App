package com.mahi.kitmanlabs.screen.splash.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahi.kitmanlabs.R.drawable
import com.mahi.kitmanlabs.util.compose.VerticalSpacer
import com.mahi.kitmanlabs.util.theme.AppColors
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
  modifier: Modifier = Modifier,
  onTimeOut: () -> Unit,
) {

  LaunchedEffect(Unit) {
    delay(600)
    onTimeOut()
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {

    Box(
      modifier = Modifier
        .size(160.dp)
        .clip(CircleShape)
        .alpha(1f),
      contentAlignment = Alignment.Center
    ) {
      Image(
        painter = painterResource(id = drawable.ic_splash_logo),
        contentDescription = "KitMansLab Splash Logo",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
      )
    }

    VerticalSpacer(25)

    Text(
      text = "KITMAN LABS",
      style = MaterialTheme.typography.titleLarge.copy(fontSize = 38.sp),
      color = AppColors.white,
      fontWeight = FontWeight.Bold
    )

  }
}