package com.example.formallanguage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView
import com.sarnava.textwriter.TextWriter

class InfoActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)


        supportActionBar?.title = "About us"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val shimmerTv1 = findViewById<ShimmerTextView>(R.id.shimmerTv1)
        val shimmer1 = Shimmer()
            .setDuration(3000)
        shimmer1.start(shimmerTv1)

        val shimmerTv2 = findViewById<ShimmerTextView>(R.id.shimmerTv2)
        val shimmer2 = Shimmer()
            .setDuration(4000)
        shimmer2.start(shimmerTv2)



    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}