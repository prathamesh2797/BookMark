package com.example.bookmark

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BooksViewModel(application: Application): AndroidViewModel(application) {

    val allBooks : LiveData<List<Books>>
    private val repository: BookRepository

    init {
        val dao =BookDatabase.getDatabase(application).getBookDao()
        repository = BookRepository(dao)
        allBooks = repository.allBooks
    }

    fun deleteNote(books: Books) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(books)
    }

    fun updateNote(books: Books) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(books)
    }

    fun insertNote(books: Books) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(books)
    }



}