package com.example.bookmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookmark.databinding.ActivityMainBinding
import com.example.bookmark.models.Books
import com.example.bookmark.viewmodel.BooksViewModel

class MainActivity : AppCompatActivity(), BookClickedInterface, BookClickedDeleteInterface {
    private lateinit var binding: ActivityMainBinding
    lateinit var booksRVAdapter: BooksRVAdapter
    lateinit var booksViewModel: BooksViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        booksViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(BooksViewModel::class.java)

        booksViewModel.allBooks.observe(this, Observer { list->

            setUpRecyclerView(list)

        })

        binding.faButton.setOnClickListener {
            val intent = Intent(this, AddEditBook::class.java)
            startActivity(intent)

        }
    }

    private fun setUpRecyclerView(list: List<Books>){


        booksRVAdapter =BooksRVAdapter(this,list,this,this)
        Log.e("RV Adapter", booksRVAdapter.toString())
        binding.rvRecyclerView.adapter = booksRVAdapter
        binding.rvRecyclerView.layoutManager =LinearLayoutManager(this@MainActivity)
    }

    override fun onBookClick(books: Books) {
      val intent = Intent(this@MainActivity,AddEditBook::class.java)
        intent.putExtra("bookType","Edit")
        intent.putExtra("userName", books.name)
        intent.putExtra("mobileNumber", books.mobileNo)
        intent.putExtra("bookName", books.bookName)
        intent.putExtra("bookID", books.id)
        intent.putExtra("selectedBookId", books.selectedBookId)

        startActivity(intent)


    }

    override fun onDeleteIconClick(books: Books) {
        booksViewModel.deleteNote(books)
        Toast.makeText(this, "Book Deleted Successfully", Toast.LENGTH_SHORT).show()
    }
}