package com.mahi.kitmanlabs.screen.athlete.list.uiModel

data class AthleteUiModel(
  val id: Int,
  val firstName: String,
  val lastName: String,
  val imageUrl: String,
  val userName: String,
  val squadIds: List<Int>,
)

fun AthleteUiModel.isQueryMatched(query: String): Boolean {
  val terms = query.trim()
    .lowercase()
    .split("\\s+".toRegex())
    .filter { it.isNotEmpty() }

  if (terms.isEmpty()) return true

  val firstName = firstName.lowercase()
  val lastName = lastName.lowercase()
  val userName = userName.lowercase()

  return terms.all { term ->
    term in firstName || term in lastName || term in userName
  }
}

