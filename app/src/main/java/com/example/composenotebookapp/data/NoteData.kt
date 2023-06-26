package com.example.composenotebookapp.data

import com.example.composenotebookapp.model.Note


class NoteDataSource{
fun loadNotes() : List<Note>{
    return  listOf(
        Note(title = "A", description = "B"),
        Note(title = "A", description = "B"),
        Note(title = "A", description = "B"),
        Note(title = "A", description = "B"),
        Note(title = "A", description = "B")

    )
}
}