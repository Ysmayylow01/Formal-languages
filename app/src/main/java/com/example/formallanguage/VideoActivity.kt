package com.example.formallanguage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formallanguage.adapter.VideoAdapter
import com.example.formallanguage.model.Video

class VideoActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var videoRecyclerView : RecyclerView
    private lateinit var videoAdapter: VideoAdapter
    private  var itemList= ArrayList<Video>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Videos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        videoRecyclerView=findViewById(R.id.videoRec)

        videoRecyclerView.setHasFixedSize(true)
        videoRecyclerView.layoutManager = LinearLayoutManager(this)



        addDataToList()

    }

    private fun addDataToList() {
        itemList = ArrayList()
        itemList.add(
            Video("Introduction to Theory of Computation", "android.resource://" + packageName + "/raw/video1"))
        itemList.add(
            Video("Formal languages", "android.resource://" + packageName + "/raw/video2"))
        itemList.add(
            Video("Introduction to Formal Languages and Automata", "android.resource://" + packageName + "/raw/video3"))



        videoAdapter = VideoAdapter(itemList)
        videoRecyclerView.adapter = videoAdapter

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}