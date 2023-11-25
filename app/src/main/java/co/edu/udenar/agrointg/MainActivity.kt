package co.edu.udenar.agrointg

import androidx.appcompat.app.AppCompatActivity
import co.edu.udenar.agrointg.data.RetrofitService
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity(){
    override fun onCreate(SavedInstanceState: Bundle?){
        super.onCreate(SavedInstanceState)
        val service = RetrofitService.RetrofitServiceFactory.makeRetrofitService()

        lifecycleScope.launch {
            val movies = service.listPopularMovies("43129791d8f75a33ef869384ca513ac8","es-CO")
            println(movies)
        }

        setContentView(R.layout.activity_main)
    }
}