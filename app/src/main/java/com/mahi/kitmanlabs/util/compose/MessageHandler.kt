package com.mahi.kitmanlabs.util.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.mahi.kitmanlabs.util.ext.showToast

@Composable
fun HandleToastMessage(toastMessage: String, onDone: () -> Unit) {
  val context = LocalContext.current
  LaunchedEffect(toastMessage) {
    if (toastMessage.isNotEmpty()) {
      context.showToast(toastMessage)
    }
    onDone()
  }
}

