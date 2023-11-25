package co.edu.udenar.agrointg.appagroint1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.edu.udenar.agrointg.R


class AdaptadorCategorias(private val categorias:List<CategoriaPlantas>) :
    RecyclerView.Adapter<CategoriasViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plantas_categorias, parent, false)
        return CategoriasViewHolder(view)
    }

    override fun getItemCount() = categorias.size

    override fun onBindViewHolder(holder: CategoriasViewHolder, position: Int) {
        holder.render(categorias[position])
    }
}