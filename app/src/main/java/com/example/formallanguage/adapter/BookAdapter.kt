package com.example.formallanguage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.formallanguage.R
import com.example.formallanguage.model.BOOK

class BookAdapter (private var kitapList:ArrayList<BOOK>)
    : RecyclerView.Adapter<BookAdapter.kitapViewHolder>(){

    var onItemClick : ((BOOK) -> Unit)? = null

    class kitapViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.bookImage)
        val textView: TextView = itemView.findViewById(R.id.bookText)
        val cardView : CardView = itemView.findViewById(R.id.cardView)


     }
    fun  setFilteredList(kitapList: ArrayList<BOOK>){
        this.kitapList= kitapList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kitapViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent , false)
        return kitapViewHolder(view)
    }

    override fun onBindViewHolder(holder: kitapViewHolder, position: Int) {
        val kitap = kitapList[position]
        holder.imageView.setImageResource(kitap.image)
        holder.textView.text = kitap.name



        holder.itemView.setOnClickListener{
            onItemClick?.invoke(kitap)

        }
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.cardView.context, R.anim.slide_in))
    }

    override fun getItemCount(): Int {
        return kitapList.size
    }



}