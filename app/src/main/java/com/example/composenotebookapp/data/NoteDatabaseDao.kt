package com.example.composenotebookapp.data

import androidx.room.*
import com.example.composenotebookapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * from notes_table")
    fun getNotes() : Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Query("DELETE from notes_table")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun deleteNote(note: Note)
}