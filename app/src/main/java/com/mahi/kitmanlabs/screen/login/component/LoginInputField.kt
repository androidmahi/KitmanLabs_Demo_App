package com.mahi.kitmanlabs.screen.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginInputFieldType(
  modifier: Modifier = Modifier,
  label: String,
  value: String,
  onValueChange: (String) -> Unit,
) {
  TextField(
    modifier = modifier
      .fillMaxWidth()
      .height(56.dp)
      .padding(horizontal = 16.dp),
    value = value,
    onValueChange = {
      onValueChange(it)
    },
    textStyle = TextStyle(
      color = Color.White,
      fontSize = 18.sp,
      fontWeight = FontWeight.Normal
    ),
    placeholder = {
      Text(
        text = label,
        color = Color.White.copy(alpha = 0.9f),
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
      )
    },
    colors = TextFieldDefaults.colors(
      unfocusedContainerColor = Color(0xFF707789),
      focusedContainerColor = Color(0xFF707789),
      cursorColor = Color.White,
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
      disabledIndicatorColor = Color.Transparent
    ),
    singleLine = true
  )
}