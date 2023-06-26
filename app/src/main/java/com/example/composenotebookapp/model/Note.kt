package com.example.composenotebookapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id : UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title : String,

    @ColumnInfo(name = "note_description")
    val description : String,

    @ColumnInfo(name = "note_timestamp")
    val timeStamp : Date = Date.from(Instant.now())
){

}
   // val timeStamp : LocalDateTime = LocalDateTime.now())