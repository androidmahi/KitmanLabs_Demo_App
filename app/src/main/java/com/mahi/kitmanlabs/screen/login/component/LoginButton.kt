package com.mahi.kitmanlabs.screen.login.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahi.kitmanlabs.util.theme.AppColors

@Composable
fun LoginButton(
  modifier: Modifier = Modifier,
  title: String,
  onClick: () -> Unit,
) {
  Text(
    modifier = modifier
      .clickable { onClick() }
      .background(color = AppColors.red, shape = RoundedCornerShape(2.dp))
      .padding(8.dp),
    style = MaterialTheme.typography.headlineMedium.copy(fontSize = 28.sp),
    color = AppColors.white,
    fontWeight = FontWeight.ExtraBold,
    text = title.uppercase()
  )
}