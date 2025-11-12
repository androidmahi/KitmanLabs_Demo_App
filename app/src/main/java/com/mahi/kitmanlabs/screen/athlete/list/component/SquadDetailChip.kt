package com.mahi.kitmanlabs.screen.athlete.list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel
import com.mahi.kitmanlabs.util.compose.clickableWithNoRipple
import com.mahi.kitmanlabs.util.theme.AppColors

@Composable
fun SquadDetailChip(
  modifier: Modifier = Modifier,
  detail: SquadUiModel,
  isForFilter: Boolean = false,
  isSelected: Boolean,
  onClick: (SquadUiModel) -> Unit,
) {

  val borderColor = if (isForFilter) {
    if (isSelected) Color.Blue else Color.Black
  } else {
    AppColors.red
  }

  val backGroundColor = if (isForFilter) {
    if (isSelected) Color.Blue else Color.Transparent
  } else {
    AppColors.red
  }

  Text(
    modifier = modifier
      .clickableWithNoRipple {
        onClick(detail)
      }
      .border(
        width = 1.dp,
        color = borderColor,
        shape = RoundedCornerShape(16.dp)
      )
      .background(
        color = backGroundColor,
        shape = RoundedCornerShape(16.dp)
      )
      .padding(10.dp),
    text = detail.name,
    style = MaterialTheme.typography.bodySmall,
    color = if (isSelected) Color.White else Color.Black
  )
}