package com.example.bookmark

import androidx.lifecycle.LiveData

class BookRepository(private val booksDao: BooksDao) {

    val allBooks: LiveData<List<Books>> = booksDao.getAllBooks()

    suspend fun insert(book: Books){
        booksDao.insert(book)
    }

    suspend fun delete(book: Books){
        booksDao.delete(book)
    }

    suspend fun update(book: Books){
        booksDao.update(book)
    }
}