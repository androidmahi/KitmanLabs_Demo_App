package com.mahi.kitmanlabs.screen.login.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahi.kitmanlabs.util.theme.AppColors

@Composable
fun TitleBanner(
  modifier: Modifier = Modifier,
  backgroundColor: Color = AppColors.blue,
  title: String
) {
  Surface(
    modifier = modifier
      .wrapContentWidth()
      .shadow(elevation = 0.dp, shape = RoundedCornerShape(12.dp)),
    color = Color.Transparent, // handled by Box background
    tonalElevation = 0.dp,
    contentColor = AppColors.white
  ) {
    Box(
      modifier = Modifier
        .background(color = backgroundColor, shape = RoundedCornerShape(12.dp))
        .padding(4.dp),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = title.uppercase(),
        color = AppColors.white,
        fontSize = 29.sp, // needs to tweak per screen density
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 1.5.sp,
        textAlign = TextAlign.Center,
        maxLines = 1
      )
    }
  }
}