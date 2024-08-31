package com.example.formallanguage.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.formallanguage.FinalActivity
import com.example.formallanguage.R
import com.example.formallanguage.model.PModel
import kotlin.collections.ArrayList

class PAdapter (private var itemList:ArrayList<PModel>)
    : RecyclerView.Adapter<PAdapter.englishViewHolder>(){
    var onItemClick : ((PModel) -> Unit)? = null

    class englishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.tvName)
        val cardView : CardView = itemView.findViewById(R.id.cardViewk)



    }
    fun  setFilteredList(itemList: ArrayList<PModel>){
        this.itemList= itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): englishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent , false)
        return englishViewHolder(view)
    }


    override fun onBindViewHolder(holder: englishViewHolder, position: Int) {
        val english = itemList[position]
        holder.textView.text = english.name



        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, FinalActivity::class.java)
            intent.putExtra("tvv", english.tv)
            intent.putExtra("titlee", english.name)
            holder.itemView.context.startActivity(intent)

        }


        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.cardView.context, R.anim.slide_in))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}

