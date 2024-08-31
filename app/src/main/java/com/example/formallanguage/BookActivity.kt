package com.example.formallanguage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formallanguage.adapter.BookAdapter
import com.example.formallanguage.model.BOOK
import java.util.*
import kotlin.collections.ArrayList

class BookActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var kitapList = ArrayList<BOOK>()
    private lateinit var adapter: BookAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        recyclerView = findViewById(R.id.recyclerView)


        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)


        supportActionBar?.title = "Books"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        addDataToList()











  }
    private fun addDataToList() {
        kitapList = ArrayList()
        kitapList.add(BOOK(R.drawable.book5, "Automata Theory, Languages and computation","formal1.pdf"))
        kitapList.add(BOOK(R.drawable.book5, "Theory of automata, formal languages and computation","formal2.pdf"))
        kitapList.add(BOOK(R.drawable.book5, "Automata and formal languages","formal3.pdf"))
        kitapList.add(BOOK(R.drawable.book5, "Formal languages and automata theory","formal4.pdf"))
        kitapList.add(BOOK(R.drawable.book5, "Formal Languages and Automata Theory","formal5.pdf"))
        kitapList.add(BOOK(R.drawable.book5, "Natural language processing with Python","formal6.pdf"))







        adapter = BookAdapter(kitapList)
        recyclerView.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, PdfActivity:: class.java)
            intent.putExtra("kitap", it)
            startActivity(intent)
        }




    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
