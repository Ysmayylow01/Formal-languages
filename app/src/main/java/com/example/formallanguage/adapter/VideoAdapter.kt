package com.example.formallanguage.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.formallanguage.FinalVideoActivity
import com.example.formallanguage.R
import com.example.formallanguage.model.Video

class VideoAdapter(private var itemList:ArrayList<Video>)
    : RecyclerView.Adapter<VideoAdapter.videoViewHolder>(){


    class videoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.texxt)
        val cardView : CardView = itemView.findViewById(R.id.cardViewv)




    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): videoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent , false)
        return videoViewHolder(view)
    }


    override fun onBindViewHolder(holder: videoViewHolder, position: Int) {
        val video = itemList[position]
        holder.textView.text = video.title



        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, FinalVideoActivity::class.java)
            intent.putExtra("tv1", video.title)
            intent.putExtra("title1", video.videoUri)
            holder.itemView.context.startActivity(intent)



        }

        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.cardView.context, R.anim.slide_in))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}

