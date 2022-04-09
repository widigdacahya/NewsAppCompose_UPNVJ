package com.cahyadesthian.newscompose.util

import java.lang.Exception
import java.text.SimpleDateFormat

object DateFormatUtil {


    // input : 2022-04-09T11:00:39Z
    // outputnyua jadi 9 Apr 2022 11:00
    fun formatDate(rawDate: String) : String {

        return try {

            val inputPattern = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val outputPattern = SimpleDateFormat("dd MMM yyyy HH:mm")

            val date = inputPattern.parse(rawDate)
            val output = outputPattern.format(date)

            output

        } catch (e: Exception) {
            rawDate
        }



    }


}