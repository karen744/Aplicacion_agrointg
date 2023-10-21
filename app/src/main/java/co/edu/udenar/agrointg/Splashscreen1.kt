package co.edu.udenar.agrointg

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import co.edu.udenar.agrointg.Splashscreen1
import co.edu.udenar.agrointg.appagroint1.Inicio

class Splashscreen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen1)

        val splashDuration = 2000L

        // Configura un temporizador para cerrar el Splash Screen después de la duración especificada
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
            finish()
        }, splashDuration)
    }
    }
