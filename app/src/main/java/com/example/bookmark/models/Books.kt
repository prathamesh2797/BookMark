package com.example.bookmark.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booksTable")
 class Books(
    @ColumnInfo(name="name")val name: String,
    @ColumnInfo(name="mobileNo")val mobileNo: String,
    @ColumnInfo(name="bookName")val bookName: String,
    @ColumnInfo(name="selectBookId")val selectedBookId:Int

    ) {
    @PrimaryKey(autoGenerate = true)var id=0

}