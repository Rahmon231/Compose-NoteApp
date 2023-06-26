package com.example.composenotebookapp.util

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    @TypeConverter
    fun timeStampFromDate(date : Date) : Long{
        return date.time
    }
    @TypeConverter
    fun dateTimeStamp(timeStamp : Long) : Date?{
        return Date(timeStamp)
    }
}