package com.example.formallanguage



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar


class FinalActivity : AppCompatActivity() {
    private lateinit var tvtext : TextView
    private lateinit var toolbar: Toolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)


        tvtext=findViewById(R.id.tvText)

        val bundle = intent.extras
        val tvText = bundle?.getString("tvv")
        val titleText = bundle?.getString("titlee")

        tvtext.text=tvText

        supportActionBar?.title = titleText
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}