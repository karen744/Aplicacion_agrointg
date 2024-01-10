package co.edu.udenar.agrointg.appagroint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.udenar.agrointg.R
import co.edu.udenar.agrointg.data.model.WeekForcast
import co.edu.udenar.agrointg.data.RetrofitService
import co.edu.udenar.agrointg.data.model.WeatherRemoteResult
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class Menu : AppCompatActivity() {
    private val listDaysForcast: MutableList<WeekForcast> = mutableListOf()
    private val listadoCategorias = listOf(
        CategoriaPlantas.Arboles(10, "Hoja grande"),
        CategoriaPlantas.Arbustos("Pequeño"),
        CategoriaPlantas.Hierbas(true)
    )

    private var lat: Double = 0.0
    private var lon: Double = 0.0
    private var pais: String = ""
    private var ciudad: String = ""
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var rvCategorias: RecyclerView
    private lateinit var categoriasAdaptador: AdaptadorCategorias
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu)



        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Verifica los permisos antes de solicitar la ubicación
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            obtenerUbicacion()
        } else {
            // Si no tienes permisos, solicítalos al usuario
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }


        iniciarComponente()
        initUI()
    }

    private fun initUI(){
        try {
            val service = RetrofitService.RetrofitServiceFactory.makeRetrofitService()

            lifecycleScope.launch {
                val daysDeferred = async {
                    //service.listPopularMovies("HEq1u9eSV3owTzra", "1.2136100", "-77.2811100")
                    service.listPopularMovies("y2FC5I1Wc4mqa7SG", lat.toString(), lon.toString())
                }

                val days = daysDeferred.await()

                // time, tem_max, tem_min, team_mean, felttem_max, felttem_min, winddirection
                // precipitacion, windspeed_max, windspeed_mean, windspeed_min,


                for(i in 0..6){
                    val dayForecast = WeekForcast.DayForcast(
                        days.data_day.felttemperature_max[i],
                        days.data_day.felttemperature_min[i],
                        days.data_day.humiditygreater90_hours[i],
                        days.data_day.precipitation_probability[i],
                        days.data_day.relativehumidity_max[i],
                        days.data_day.relativehumidity_mean[i],
                        days.data_day.relativehumidity_min[i],
                        days.data_day.temperature_max[i],
                        days.data_day.temperature_mean[i],
                        days.data_day.temperature_min[i],
                        days.data_day.time[i],
                        days.data_day.winddirection[i],
                        days.data_day.windspeed_max[i],
                        days.data_day.windspeed_mean[i],
                        days.data_day.windspeed_min[i],
                        days.data_day.pictocode[i]
                    )
                    listDaysForcast.add(dayForecast)

                    categoriasAdaptador = AdaptadorCategorias(listDaysForcast)
                    rvCategorias.layoutManager = LinearLayoutManager(this@Menu, LinearLayoutManager.HORIZONTAL, false)
                    rvCategorias.adapter = categoriasAdaptador
                }

            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }
    private fun iniciarComponente() {
        rvCategorias = findViewById(R.id.rvPlantas)
    }

    private fun obtenerUbicacion() {
        // Verifica nuevamente los permisos antes de obtener la ubicación
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Obtiene la última ubicación conocida
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location != null) {
                        lat = location.latitude
                        lon = location.longitude

                        Toast.makeText(
                            this,
                            "Ubicación actual: Latitud $lat, Longitud $lon",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        lat = 1.2136100
                        lon = -77.2811100
                    }
                }
        }
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                obtenerUbicacion()
            } else {
                Toast.makeText(
                    this,
                    "Permiso de ubicación denegado. No se puede obtener la ubicación.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        private const val REQUEST_LOCATION_PERMISSION = 1
    }
}