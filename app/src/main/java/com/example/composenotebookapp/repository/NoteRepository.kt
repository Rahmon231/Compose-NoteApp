package com.example.composenotebookapp.repository

import com.example.composenotebookapp.model.Note
import com.example.composenotebookapp.data.NoteDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {

    suspend fun addNote(note : Note){
        noteDatabaseDao.insertNote(note)
    }
    suspend fun deleteNote(note: Note){
        noteDatabaseDao.deleteNote(note)
    }
    suspend fun updateNote(note: Note){
        noteDatabaseDao.updateNote(note)
    }
    suspend fun deleteAllNotes(){
        noteDatabaseDao.deleteAllNotes()
    }

    fun getAllNotes() : Flow<List<Note>>{
        return noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
    }
}