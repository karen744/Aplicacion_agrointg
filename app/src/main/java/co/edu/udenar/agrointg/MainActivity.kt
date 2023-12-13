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
            val movies = service.listPopularMovies("HEq1u9eSV3owTzra", "1.2136100", "-77.2811100")
            val result = movies.data_day
            // time, tem_max, tem_min, team_mean, felttem_max, felttem_min, winddirection
            // precipitacion, windspeed_max, windspeed_mean, windspeed_min,
            println(result)
        }

        setContentView(R.layout.activity_main)
    }
}