package co.edu.udenar.agrointg.appagroint1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.udenar.agrointg.R
import com.bumptech.glide.Glide

class PlantasAdapter(var con : Context , var list : List<UsersItem>) : RecyclerView.Adapter<PlantasAdapter.ViewHolder>() {

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        //var img = v.findViewById<ImageView>(R.id.RV_Image)
        var tvName = v.findViewById<TextView>(R.id.RV_tv)
        var tvFamily = v.findViewById<TextView>(R.id.FV_tv)
        var tvGenus = v.findViewById<TextView>(R.id.GV_tv)
        var tvOrder = v.findViewById<TextView>(R.id.OV_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Glide.with(con).load(list[position].url).into(holder.img)
        val currentItem = list[position]

        holder.tvName.text = "Name: ${currentItem.name}"
        holder.tvFamily.text = "Family: ${currentItem.family}"
        holder.tvGenus.text = "Genus: ${currentItem.genus}"
        holder.tvOrder.text = "Order: ${currentItem.order}"

    }

    override fun getItemCount(): Int {
        return list.count()
    }

}