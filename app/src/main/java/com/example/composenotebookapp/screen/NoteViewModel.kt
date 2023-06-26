package com.example.composenotebookapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenotebookapp.model.Note
import com.example.composenotebookapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) :  ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()
   // private var noteList  = mutableStateListOf<Note>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect{
               if (it.isNullOrEmpty()){
                   Log.d("TAG", ": Null")
               }else{
                   _noteList.value = it
               }
            }
        }
       // noteList.addAll(NoteDataSource().loadNotes())
    }
     fun addNote(note: Note) = viewModelScope.launch {noteRepository.addNote(note)}

    fun removeNote(note: Note) = viewModelScope.launch { noteRepository.deleteNote(note) }

    fun getAllNotes() : Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }
}