package com.example.bookmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmark.databinding.ActivityAddEditBookBinding
import com.example.bookmark.databinding.ActivityMainBinding

class AddEditBook : AppCompatActivity() {

    private lateinit var binding: ActivityAddEditBookBinding
    lateinit var booksViewModel: BooksViewModel
    var bookID =-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        booksViewModel =ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(BooksViewModel::class.java)


        val bookType = intent.getStringExtra("bookType")
        if (bookType.equals("Edit")){
            val userName = intent.getStringExtra("userName")
            val mobileNumber = intent.getIntExtra("mobileNumber",-2)
            val bookName = intent.getStringExtra("bookName")
            bookID = intent.getIntExtra("bookID",-1)

            binding.apply {
                btnSubmitButton.text ="UPDATE"
                etUserName.setText(userName)
                etMobileNumber.setText(mobileNumber.toString())
                etBookName.setText(bookName)
            }
        }else{
            binding.btnSubmitButton.text ="SUBMIT"

        }

        binding.btnSubmitButton.setOnClickListener {

            Log.e("Submit button click",bookType.toString())

            if (bookType.equals("Edit")){
                if (binding.etUserName.text.isNullOrEmpty() ||
                    binding.etMobileNumber.text.toString().isNullOrEmpty() ||
                    binding.etBookName.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Username, Mobile Number and Book Name are mandatory", Toast.LENGTH_SHORT).show()

                }else{

                    val userName =binding.etUserName.text
                    val mobileNumber = (binding.etMobileNumber.text.toString()).toInt()
                    val bookName = binding.etBookName.text

                    val updateBook = Books(userName.toString(),mobileNumber,bookName.toString())
                    updateBook.id = bookID
                    booksViewModel.updateNote(updateBook)
                    Toast.makeText(this, "Book Details Updated Successfully", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    this.finish()


                }


            }else{
                if (binding.etUserName.text.isNullOrEmpty() ||
                    binding.etMobileNumber.text.toString().isNullOrEmpty() ||
                    binding.etBookName.text.isNullOrEmpty()){
                    Toast.makeText(this, "Username, Mobile Number and Book Name are mandatory", Toast.LENGTH_SHORT).show()
                }else{

                    val userName =binding.etUserName.text
                    val mobileNumber = (binding.etMobileNumber.text.toString()).toInt()
                    val bookName = binding.etBookName.text

                    booksViewModel.insertNote(Books(userName.toString(), mobileNumber, bookName.toString()))

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    this.finish()

                    Toast.makeText(applicationContext, "Book Details Saved Successfully $userName $mobileNumber $bookName", Toast.LENGTH_SHORT).show()
                }
            }


        }


    }



}