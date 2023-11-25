package co.edu.udenar.agrointg.appagroint1

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.udenar.agrointg.R

class CategoriasViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val tvNombreCategoria: TextView = view.findViewById(R.id.textViewCategoria)
    private val divisionView: View = view.findViewById(R.id.divisionCategoria)
    fun render (categoriaPlantas: CategoriaPlantas){
        tvNombreCategoria.text = "Arboles"
    }
}