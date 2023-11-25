package co.edu.udenar.agrointg.appagroint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.udenar.agrointg.R

class Menu : AppCompatActivity() {

    private val listadoCategorias = listOf(
        CategoriaPlantas.Arboles,
        CategoriaPlantas.Arbustos,
        CategoriaPlantas.Hiervas
    )

    private lateinit var rvCategorias: RecyclerView
    private lateinit var categoriasAdaptador: AdaptadorCategorias
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        iniciarComponente()
        initUI()
    }

    private fun initUI(){
        categoriasAdaptador = AdaptadorCategorias(listadoCategorias)
        rvCategorias.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorias.adapter = categoriasAdaptador
    }
    private fun iniciarComponente() {
        rvCategorias = findViewById(R.id.rvPlantas)
    }
}