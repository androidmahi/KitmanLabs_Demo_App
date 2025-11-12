package com.mahi.kitmanlabs.screen.athlete.list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahi.kitmanlabs.util.theme.AppColors
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.sp
import com.mahi.kitmanlabs.util.compose.HorizontalSpacer

@Composable
fun SearchBar(
  modifier: Modifier = Modifier,
  query: String,
  onQueryChange: (String) -> Unit,
) {

  Surface(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 12.dp),
    shape = RoundedCornerShape(28.dp),
    color = AppColors.white,
    tonalElevation = 2.dp
  ) {

    Row(
      Modifier
        .height(48.dp)
        .fillMaxWidth()
        .padding(horizontal = 12.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {

      Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "Search",
        tint = AppColors.blue
      )

      HorizontalSpacer(10)


      Box(modifier = Modifier.weight(1f)) {
        if (query.isEmpty()) {
          Text(
            text = "Search athletes, squads...",
            color = AppColors.black,
            fontSize = 14.sp
          )
        }
        BasicTextField(
          modifier = Modifier.fillMaxWidth(),
          value = query,
          onValueChange = onQueryChange,
          singleLine = true,
          maxLines = 1,
          textStyle = LocalTextStyle.current.copy(color = AppColors.black, fontSize = 15.sp),
          cursorBrush = SolidColor(AppColors.blue),
        )
      }

      if (query.isNotEmpty()) {
        HorizontalSpacer(8)
        IconButton(
          onClick = { onQueryChange("") },
          modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(AppColors.blue.copy(alpha = 0.12f))
        ) {
          Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "Clear",
            tint = AppColors.blue
          )
        }
      }

    }

  }
}