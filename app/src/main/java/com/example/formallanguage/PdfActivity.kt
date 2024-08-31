package com.example.formallanguage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.formallanguage.model.BOOK
import com.github.barteksc.pdfviewer.PDFView

class PdfActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)
        val pdfView : PDFView = findViewById(R.id.btnpdf)
        val kitap = intent.getParcelableExtra<BOOK>("kitap")
        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)


        if (kitap != null) {
            supportActionBar?.title = kitap.name
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        if (kitap != null) {
            pdfView.fromAsset(kitap.pdf).load()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}