package com.example.bookmark.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bookmark.models.Books

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(books: Books)

    @Delete
    suspend fun delete(books: Books)

    @Update
    suspend fun update(books: Books)

    @Query("Select * from booksTable order by id desc")
    fun getAllBooks(): LiveData<List<Books>>
}