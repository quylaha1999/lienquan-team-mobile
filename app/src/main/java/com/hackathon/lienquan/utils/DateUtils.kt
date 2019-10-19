package com.hackathon.lienquan.utils

import com.hackathon.lienquan.utils.DateFormat.DEFAULT_ZONE
import com.hackathon.lienquan.utils.DateFormat.FORMAT_DD_MM_YYYY
import com.hackathon.lienquan.utils.DateFormat.FORMAT_YYYY_MM_DD
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateFormat {
    const val FORMAT_YYYY_MM_DD = "yyyy-MM-dd"
    const val FORMAT_DD_MM_YYYY = "dd/MM/yyyy"
    const val DEFAULT_ZONE = "ICT"
}

fun convertDate2(input: String?, outputFormat: String): String? {
    input?.let {
        val dateFormat = SimpleDateFormat(FORMAT_YYYY_MM_DD, Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone(DEFAULT_ZONE)
        try {
            val date = dateFormat.parse(input)
            return SimpleDateFormat(outputFormat, Locale.getDefault()).format(date)
        } catch (e: ParseException) {
            //server send datetime in wrong format
        }
    }
    return null
}

fun convertToDateOnly(input: String): String? {
    return convertDate2(input, FORMAT_DD_MM_YYYY)
}