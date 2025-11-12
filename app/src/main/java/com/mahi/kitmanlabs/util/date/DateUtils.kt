package com.mahi.kitmanlabs.util.date

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateUtils {

  @RequiresApi(Build.VERSION_CODES.O)
  fun getProperDateValueFromIsoDateString(isoString: String): String {
    val instant = Instant.parse(isoString) // parse ISO string in UTC
    val localDateTime = instant.atZone(ZoneId.systemDefault()) // convert to your local timezone
    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a") // customize format
    return localDateTime.format(formatter)
  }


}