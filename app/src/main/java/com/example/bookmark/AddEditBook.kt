package com.example.bookmark

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.bookmark.databinding.ActivityAddEditBookBinding

import android.widget.TextView
import com.example.bookmark.models.Books
import com.example.bookmark.viewmodel.BooksViewModel


class AddEditBook : AppCompatActivity() {

    private lateinit var binding: ActivityAddEditBookBinding
    lateinit var booksViewModel: BooksViewModel
    var bookID =0

    private var bookSelected="Book1"
    private var selectedBookId=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etBookName.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {

                bookSelected = p0?.getItemAtPosition(position).toString()
                (p0?.getChildAt(0) as TextView).setTextColor(Color.parseColor("#D1D1D1"))

                (p0.getChildAt(0) as TextView).textSize = 18f
                selectedBookId = position
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }




        booksViewModel =ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(BooksViewModel::class.java)


        val bookType = intent.getStringExtra("bookType")
        if (bookType.equals("Edit")){

            supportActionBar?.title ="Update Book"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)

            val userName = intent.getStringExtra("userName")
            val mobileNumber = intent.getStringExtra("mobileNumber")
            val bookName = intent.getStringExtra("bookName")
            val selectedBookId = intent.getIntExtra("selectedBookId", 0)
            bookID = intent.getIntExtra("bookID",-1)

            binding.apply {
                btnSubmitButton.text ="UPDATE"
                etUserName.setText(userName)
                etMobileNumber.setText(mobileNumber.toString())
//                etBookName.setText(bookName)
                etBookName.setSelection(selectedBookId)

            }
        }else{

            supportActionBar?.title ="Add Book"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            binding.btnSubmitButton.text ="SUBMIT"

        }

        binding.btnSubmitButton.setOnClickListener {

            Log.e("Submit button click",bookType.toString())

            if (bookType.equals("Edit")){
                if (binding.etUserName.text.isNullOrEmpty() ||
                    binding.etMobileNumber.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "Username, Mobile Number and Book Name are mandatory", Toast.LENGTH_SHORT).show()

                }else if (binding.etMobileNumber.text.toString().length != 10) {
                    Toast.makeText(this, "Please Enter a Valid Mobile Number", Toast.LENGTH_SHORT).show()
                }

                else{

                    val userName =binding.etUserName.text
                    val mobileNumber = (binding.etMobileNumber.text.toString())
                    val bookName = bookSelected

                    val updateBook = Books(userName.toString(),mobileNumber,bookName.toString(), selectedBookId)
                    updateBook.id = bookID
                    booksViewModel.updateNote(updateBook)
                    Toast.makeText(this, "Book Details Updated Successfully", Toast.LENGTH_SHORT).show()

                  /*  val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)*/
                    this.finish()


                }


            }else{
                if (binding.etUserName.text.isNullOrEmpty() ||
                    binding.etMobileNumber.text.toString().isNullOrEmpty()){
                    Toast.makeText(this, "Username, Mobile Number and Book Name are mandatory", Toast.LENGTH_SHORT).show()
                }
                else if (binding.etMobileNumber.text.toString().length != 10) {
                    Toast.makeText(this, "Please Enter a Valid 10 digit Mobile Number", Toast.LENGTH_SHORT).show()
                }

                else{

                    val userName =binding.etUserName.text
                    val mobileNumber = binding.etMobileNumber.text.toString()
                    val bookName = bookSelected.toString()

                    booksViewModel.insertNote(Books(userName.toString(), mobileNumber, bookName.toString(), selectedBookId))

                  /*  val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)*/
                    this.finish()

                    Toast.makeText(applicationContext, "Book Details Saved Successfully $userName $mobileNumber $bookName", Toast.LENGTH_SHORT).show()
                }
            }


        }


    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            startActivity(Intent(this, MainActivity::class.java))
            this.finish()
        }

        return super.onOptionsItemSelected(item)
    }



}