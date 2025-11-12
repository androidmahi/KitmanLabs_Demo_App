package com.mahi.kitmanlabs.screen.athlete.list.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import com.mahi.kitmanlabs.screen.athlete.list.bottomsheet.SquadDetailBottomSheet
import com.mahi.kitmanlabs.screen.athlete.list.component.AthleteCard
import com.mahi.kitmanlabs.screen.athlete.list.component.SearchBar
import com.mahi.kitmanlabs.screen.athlete.list.event.AthleteScreenEvent
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.SquadUiModel
import com.mahi.kitmanlabs.screen.athlete.list.uiModel.isQueryMatched
import com.mahi.kitmanlabs.screen.athlete.list.viewModel.AthleteInfoUiState
import com.mahi.kitmanlabs.screen.login.component.TitleBanner
import com.mahi.kitmanlabs.util.compose.VerticalSpacer
import com.mahi.kitmanlabs.util.theme.AppColors

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AthleteListScreen(
  modifier: Modifier = Modifier,
  uiState: AthleteInfoUiState,
  onEvent: (AthleteScreenEvent) -> Unit,
) {

  LaunchedEffect(Unit) {
    onEvent.invoke(AthleteScreenEvent.OnFetchInitialData)
  }

  Scaffold(
    modifier = modifier,
    topBar = {
      Column(
        modifier = Modifier
          .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        TitleBanner(
          modifier = Modifier
            .fillMaxWidth(),
          title = "Athlete Details"
        )
      }
    }
  ) { paddingValues ->

    var currentClickedSquadUiModel by remember { mutableStateOf<SquadUiModel?>(null) }

    Box(
      modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()
    ) {


      Column(
        modifier = Modifier.fillMaxSize()
      ) {

        VerticalSpacer(8)

        SearchBar(
          query = uiState.searchQuery,
          onQueryChange = { updatedQuery ->
            onEvent.invoke(AthleteScreenEvent.OnSearchQueryUpdated(updatedQuery))
          }
        )

        val filteredList = remember(uiState.searchQuery, uiState.athleteList) {
          derivedStateOf {
            if (uiState.searchQuery.isEmpty()) {
              uiState.athleteList
            } else {
              //todo include search by squad name also
              uiState.athleteList.filter {
                it.isQueryMatched(uiState.searchQuery)
              }
            }
          }
        }

        LazyColumn(
          modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 5.dp)
        ) {

          itemsIndexed(
            items = filteredList.value,
            key = { index, model -> "$index ${model.userName}" }
          ) { _, model ->
            AthleteCard(
              uiModel = model,
              squadDetailMap = uiState.squadDetailsMap,
              onSquadClick = {
                currentClickedSquadUiModel = it
              },
              onClick = {}
            )
          }

        }
      }

      if (currentClickedSquadUiModel != null) {
        SquadDetailBottomSheet(
          squadUiModel = currentClickedSquadUiModel!!,
          onDismiss = {
            currentClickedSquadUiModel = null
          }
        )
      }

    }

  }
}