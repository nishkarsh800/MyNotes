package com.example.techprojects.activity.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.techprojects.activity.model.NoteBook
import com.example.techprojects.activity.repository.NotebookRepo
import kotlinx.coroutines.launch

class NoteBookViewModel : ViewModel(){

    val repo=NotebookRepo()
    val list=MutableLiveData<List<NoteBook>>()
    fun insert(context: Context,notebook: NoteBook){
        viewModelScope.launch {
            repo.insert(context,notebook)
        }
    }

    fun delete(context: Context,notebook: NoteBook){
        viewModelScope.launch {
            repo.delete(context,notebook)
        }
    }

    fun getAllNotebooks(context: Context){
        viewModelScope.launch {
            list.value = repo.getAllNotebooks(context)
        }
    }
}