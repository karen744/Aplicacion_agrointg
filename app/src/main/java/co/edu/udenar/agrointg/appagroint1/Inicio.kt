package co.edu.udenar.agrointg.appagroint1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import android.widget.Toast
import co.edu.udenar.agrointg.R

class Inicio : AppCompatActivity() {

    private lateinit var imageButton: ImageButton
    private lateinit var buttonRegistroPersonas: Button
    private lateinit var buttonIniciarSesion: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        imageButton = findViewById(R.id.imageButton)
        buttonRegistroPersonas = findViewById(R.id.button2)
        buttonIniciarSesion = findViewById(R.id.button3)

        imageButton.setOnClickListener {
            showToast("Karen Mutis, David Guerrero, Felipe Arteaga, AGROINT")
        }

        buttonRegistroPersonas.setOnClickListener {
            // Iniciar la actividad de registro de personas
            val intent = Intent(this, RegistroPersonas::class.java)
            startActivity(intent)
        }
        buttonIniciarSesion.setOnClickListener {
            // Iniciar la actividad de registro de personas
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }



    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
