package com.mahi.kitmanlabs.screen.athlete.list.bottomsheet

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel
import com.mahi.kitmanlabs.util.compose.HorizontalSpacer
import com.mahi.kitmanlabs.util.compose.VerticalSpacer
import com.mahi.kitmanlabs.util.date.DateUtils
import com.mahi.kitmanlabs.util.theme.AppColors

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SquadDetailBottomSheet(
  modifier: Modifier = Modifier,
  squadUiModel: SquadUiModel,
  onDismiss: () -> Unit,
) {
  ModalBottomSheet(
    onDismissRequest = onDismiss,
    sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false),
    tonalElevation = 8.dp,
    modifier = modifier
  ) {
    SquadDialogContent(
      uiModel = squadUiModel
    )
  }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SquadDialogContent(
  modifier: Modifier = Modifier,
  uiModel: SquadUiModel,
) {
  Column(
    modifier = modifier
      .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top
  ) {

    Text(
      modifier = Modifier.padding(bottom = 15.dp),
      text = "${uiModel.name} Detail",
      style = MaterialTheme.typography.titleLarge,
      fontWeight = FontWeight.Bold,
      color = AppColors.white,
      fontFamily = FontFamily.SansSerif
    )

    VerticalSpacer(5)
    HorizontalDivider()
    VerticalSpacer(5)

    VerticalSpacer(10)

    Column(
      modifier = Modifier.padding(horizontal = 18.dp)
    ) {
      SquadDetailRow(
        label = "Squad ID",
        value = uiModel.id.toString()
      )
      VerticalSpacer(3)

      SquadDetailRow(
        label = "Org ID",
        value = uiModel.orgId.toString()
      )
      VerticalSpacer(3)

      SquadDetailRow(
        label = "Created At",
        value = DateUtils.getProperDateValueFromIsoDateString(uiModel.createdAt)
      )
      VerticalSpacer(3)

      SquadDetailRow(
        label = "Updated At",
        value = DateUtils.getProperDateValueFromIsoDateString(uiModel.updatedAt)
      )
      VerticalSpacer(3)
    }

    VerticalSpacer(15)

  }
}

@Composable
fun SquadDetailRow(
  modifier: Modifier = Modifier,
  label: String,
  value: String,
) {
  Row(
    modifier = modifier
      .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {

    Text(
      text = "$label :",
      style = MaterialTheme.typography.titleMedium,
      color = AppColors.white,
      fontFamily = FontFamily.SansSerif
    )

    HorizontalSpacer(5)

    Text(
      text = value,
      style = MaterialTheme.typography.titleMedium,
      color = AppColors.white,
      fontFamily = FontFamily.SansSerif
    )

  }
}