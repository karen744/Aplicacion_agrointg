package co.edu.udenar.agrointg.appagroint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import co.edu.udenar.agrointg.R

class Inicio : AppCompatActivity() {

        private lateinit var imageButton: ImageButton

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_inicio)


            imageButton = findViewById(R.id.imageButton)


            imageButton.setOnClickListener {

                showToast("Karen Mutis, David Guerrero, Felipe Arteaga, AGROINT")
            }
        }

        private fun showToast(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }