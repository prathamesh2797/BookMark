package com.example.bookmark

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmark.databinding.BooksItemBinding

class BooksRVAdapter(
    private val context: Context,
    private val bookList: List<Books>,
    val bookClickedDeleteInterface: BookClickedDeleteInterface,
    val bookClickedInterface: BookClickedInterface) : RecyclerView.Adapter<BooksRVAdapter.BooksViewHolder>() {

    inner class BooksViewHolder(var binding: BooksItemBinding): RecyclerView.ViewHolder(binding.root)

  /*  private val diffCallBack = object : DiffUtil.ItemCallback<Books>(){
        override fun areItemsTheSame(oldItem: Books, newItem: Books): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Books, newItem: Books): Boolean {
            return oldItem == newItem
        }


    }
    private val differ = AsyncListDiffer(this, diffCallBack)
    var bookList:List<Books>
        get() {
            return differ.currentList
        }
        set(value) {differ.submitList(value)}*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView = BooksItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BooksViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {

        holder.binding.apply {
            val currentBook =bookList[position]
            tvUserName.text = currentBook.name
            tvBookName.text = currentBook.bookName
            tvMobileNumber.text = currentBook.mobileNo.toString()
        }

        holder.binding.ivDelete.setOnClickListener {
            bookClickedDeleteInterface.onDeleteIconClick(bookList[position])
        }

        holder.binding.root.setOnClickListener {
            bookClickedInterface.onBookClick(bookList[position])
        }

    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}

interface BookClickedDeleteInterface{
    fun onDeleteIconClick(books: Books)
}

interface BookClickedInterface{
    fun onBookClick(books: Books)
}