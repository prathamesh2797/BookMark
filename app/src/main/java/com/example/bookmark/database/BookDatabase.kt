package com.example.bookmark.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookmark.models.Books

@Database(entities = arrayOf(Books::class), version = 3, exportSchema = false)
abstract class BookDatabase: RoomDatabase() {

    abstract fun getBookDao(): BooksDao

    companion object{
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getDatabase(context: Context): BookDatabase {
            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(context.applicationContext,
                    BookDatabase::class.java,"book_database").fallbackToDestructiveMigration().build()

                INSTANCE = instance

                instance
            }

        }
    }
}