package com.example.techprojects.activity.repository

import android.content.Context
import com.example.techprojects.activity.model.NoteBook
import com.example.techprojects.activity.room.NoteBookDatabase

class NotebookRepo {

    suspend fun insert(context: Context,noteBook: NoteBook){
        NoteBookDatabase.get(context).getNotebookDao().insert(noteBook)
    }

    suspend fun delete(context: Context,noteBook: NoteBook){
        NoteBookDatabase.get(context).getNotebookDao().delete(noteBook)
    }

    suspend fun getAllNotebooks(context: Context):List<NoteBook>{
       return NoteBookDatabase.get(context).getNotebookDao().getAllNotebook()
    }
}