package com.example.bookmark

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booksTable")
 class Books(
    @ColumnInfo(name="name")val name: String,
    @ColumnInfo(name="mobileNo")val mobileNo: Int,
    @ColumnInfo(name="bookName")val bookName: String,

    ) {
    @PrimaryKey(autoGenerate = true)var id=0

}