package com.example.bookmark

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(books: Books)

    @Delete
    suspend fun delete(books: Books)

    @Update
    suspend fun update(books: Books)

    @Query("Select * from booksTable order by id asc")
    fun getAllBooks(): LiveData<List<Books>>
}