package com.example.formallanguage

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.widget.Toolbar


class FinalVideoActivity : AppCompatActivity() {
    private lateinit var videoView :VideoView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_video)
        videoView=findViewById(R.id.videoView)

        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)

        val tvText = intent.getStringExtra("tv1")

        supportActionBar?.title = tvText
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val videouri = intent.getStringExtra("title1")

        val videoPath = videouri
        val uri = Uri.parse(videoPath)

        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)


        videoView.start()

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}