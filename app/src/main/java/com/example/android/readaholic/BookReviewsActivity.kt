package com.example.android.readaholic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_book_page.*
import kotlinx.android.synthetic.main.activity_book_reviews.*
import kotlinx.android.synthetic.main.bookreview.view.*
import kotlin.math.min

class BookReviewsActivity : AppCompatActivity() {
    var bookr:ArrayList<BookReview>?=null
    var adapter:ReviewAdabterlist1?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_reviews)
        bookr= ArrayList()
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))
        bookr!!.add(BookReview("sadfas"))


        adapter= ReviewAdabterlist1()
        booklistui.adapter=adapter
    }



    inner class ReviewAdabterlist1(): BaseAdapter()
    {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var myview=layoutInflater.inflate(R.layout.bookreview,null)
            var currentreview= bookr!![position]
            myview.reviwernametxtui.text=currentreview.name
            myview.readmoretxtui.setOnClickListener {
                Toast.makeText(applicationContext,"Read More ??>>>>", Toast.LENGTH_SHORT).show()
            }
            return myview
        }

        override fun getItem(position: Int): Any {
            return  bookr!![position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return bookr!!.size
        }


    }
}
