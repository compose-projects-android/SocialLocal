package org.compose_projects.socialLocal.core.data.common

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

class TimeManager {
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDay() : String {
        val day = LocalDate.now()
        return day.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("es", "ES"))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getHour() : String {
        val hour = LocalTime.now()
        return hour.format(DateTimeFormatter.ofPattern("HH:mm"))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDayOfMonth() : String {
        val day = LocalDate.now()
        return day.format(DateTimeFormatter.ofPattern("dd"))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getMonthOfYear() : String {
        val month = LocalDate.now()
        return month.month.getDisplayName(TextStyle.FULL, Locale("es", "ES"))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDateTime() =
        "${getDay()} - ${getDayOfMonth()} de ${getMonthOfYear()} ${getHour()}"

}