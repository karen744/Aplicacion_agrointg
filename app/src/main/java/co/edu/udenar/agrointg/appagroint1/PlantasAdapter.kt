package com.example.retrofit_yt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.udenar.agrointg.R
import co.edu.udenar.agrointg.appagroint1.Data
import com.bumptech.glide.Glide

class PlantasAdapter(var con : Context , var list : List<Data>) : RecyclerView.Adapter<PlantasAdapter.ViewHolder>() {

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        //var img = v.findViewById<ImageView>(R.id.RV_Image)
        var tvName = v.findViewById<TextView>(R.id.RV_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Glide.with(con).load(list[position].default_image).into(holder.img)

        holder.tvName.text = list[position].common_name

    }

    override fun getItemCount(): Int {
        return list.count()
    }

}