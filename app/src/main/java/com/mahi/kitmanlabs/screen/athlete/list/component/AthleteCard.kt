package com.mahi.kitmanlabs.screen.athlete.list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.AthleteUiModel
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel
import com.mahi.kitmanlabs.util.compose.HorizontalSpacer
import com.mahi.kitmanlabs.util.compose.VerticalSpacer
import com.mahi.kitmanlabs.util.theme.AppColors

@Composable
fun AthleteCard(
  modifier: Modifier = Modifier,
  uiModel: AthleteUiModel,
  squadDetailMap: Map<Int, SquadUiModel>,
  onClick: () -> Unit,
  onSquadClick: (SquadUiModel) -> Unit,
) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .clickable { onClick() }
      .padding(10.dp),
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = AppColors.white),
    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
  ) {

    Row(
      modifier = Modifier.fillMaxWidth()
    ) {

      Box(
        modifier = Modifier
          .weight(0.3f)
          .size(100.dp)
          .padding(vertical = 10.dp)
          .clip(RoundedCornerShape(18.dp))
      ) {
        AsyncImage(
          modifier = Modifier
            .fillMaxSize(),
          model = uiModel.imageUrl,
          contentDescription = "User Avatar",
        )
      }

      HorizontalSpacer(10)

      Column(
        modifier = Modifier
          .weight(0.7f)
          .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
      ) {

        Text(
          text = "${uiModel.firstName} ${uiModel.lastName}",
          color = AppColors.black,
          style = MaterialTheme.typography.titleLarge,
          fontWeight = FontWeight.ExtraBold,
          maxLines = 1,
          fontSize = 18.sp
        )

        VerticalSpacer(5)

        Text(
          text = uiModel.userName,
          color = AppColors.blue,
          style = MaterialTheme.typography.titleSmall,
          fontSize = 13.sp,
          maxLines = 1
        )

        VerticalSpacer(8)

        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {

          val squadUiModels = uiModel.squadIds.mapNotNull { squadDetailMap[it] }

          if (squadUiModels.isNotEmpty()) {
            itemsIndexed(items = squadUiModels) { index, squadUiModel ->
              SquadDetailChip(
                detail = squadUiModel,
                isSelected = true,
                onClick = { onSquadClick(it) }
              )
            }
          }

        }

        VerticalSpacer(5)

      }

    }
  }
}

@Preview(showBackground = true, backgroundColor = 0xFF111111)
@Composable
private fun AthleteCardPreview() {
  val sampleAthleteUiModel =
    AthleteUiModel(
      id = 1,
      firstName = "John",
      lastName = "Doe",
      imageUrl = "https://kitman.imgix.net/avatar.jpg",
      userName = "jdoe1",
      squadIds = listOf(101, 102)
    )

  val sampleSquadUiModel = listOf(
    SquadUiModel(
      id = 101,
      name = "Squad A",
      orgId = 1,
      createdAt = "2023-01-01T10:00:00.000Z",
      updatedAt = "2023-01-01T10:00:00.000Z"
    )
  )

  AthleteCard(
    uiModel = sampleAthleteUiModel,
    squadDetailMap = sampleSquadUiModel.associateBy { it.id },
    onClick = {},
    onSquadClick = {}
  )
}