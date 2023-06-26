package com.example.composenotebookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.composenotebookapp.model.Note
import com.example.composenotebookapp.screen.NoteScreen
import com.example.composenotebookapp.screen.NoteViewModel
import com.example.composenotebookapp.ui.theme.ComposeNotebookAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotebookAppTheme {

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background)
                {
                    val noteViewModel : NoteViewModel by viewModels()
                    NoteApp(noteViewModel)

                }
            }
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel){
    val noteList = noteViewModel.noteList.collectAsState().value
    NoteScreen(notes = noteList, onAddNote =
    {
        noteViewModel.addNote(it)
    } , onRemoveNote = {
        noteViewModel.removeNote(it)
    })

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNotebookAppTheme {
        val notes = remember {
            mutableStateListOf<Note>()
        }
NoteScreen(notes = notes, onAddNote ={ notes.add(it)} , onRemoveNote ={ notes.remove(it)} )
    }
}