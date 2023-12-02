package co.edu.udenar.agrointg.appagroint1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.udenar.agrointg.R
import co.edu.udenar.agrointg.data.model.WeekForcast
import kotlin.math.roundToInt
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CategoriasViewHolder(view:View) : RecyclerView.ViewHolder(view){


    private val tvDay: TextView = view.findViewById(R.id.textViewDay)
    private val tvTime: TextView = view.findViewById(R.id.textViewTime)
    private val tvFeltTemperatureMax: TextView = view.findViewById(R.id.textViewFeltTemperatureMax)
    private val tvHumidityMax: TextView = view.findViewById(R.id.textViewHumidityMax)
    private val tvHumidityMin: TextView = view.findViewById(R.id.textViewHumidityMin)
    private val tvPresipitationPro: TextView = view.findViewById(R.id.textViewPresipitationPro)
    private val tvTemperatureMax: TextView = view.findViewById(R.id.textViewTemperatureMax)
    private val tvTemperatureMin: TextView = view.findViewById(R.id.textViewTemperatureMin)
    private val tvWindDirection: TextView = view.findViewById(R.id.textViewWindDirection)
    private val tvWindSpeedMax: TextView = view.findViewById(R.id.textViewWindSpeedMax)
    private val tvWindSpeedMin: TextView = view.findViewById(R.id.textViewWindSpeedMin)
    private val divisionView: View = view.findViewById(R.id.divisionCategoria)
    private val imgWeather: ImageView = view.findViewById(R.id.imgWeather)
    fun render(weekForcast: WeekForcast) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        when(weekForcast){
          is WeekForcast.DayForcast -> {
              val kmhWindMax = weekForcast.windspeed_max * 3.6
              val kmhWindMin = weekForcast.windspeed_min * 3.6

              // Parsea la fecha a partir de una cadena (puedes obtener la fecha de tus datos)
              val dateString = weekForcast.time // Reemplaza esto con tu fecha
              val date = dateFormat.parse(dateString)

              // Obtiene el día de la semana a partir de la fecha
              val dayOfWeek = SimpleDateFormat("EEEE", Locale("es", "ES")).format(date)

              tvDay.text = "${dayOfWeek}"
              tvTime.text = "${weekForcast.time}"
              tvFeltTemperatureMax.text = "${weekForcast.felttemperature_max.roundToInt()} °C"
              tvHumidityMax.text = "${weekForcast.relativehumidity_max}%"
              tvHumidityMin.text = "${weekForcast.relativehumidity_min}%"
              tvPresipitationPro.text = "${weekForcast.precipitation_probability}%"
              tvTemperatureMax.text = "${weekForcast.temperature_max.roundToInt()} °C"
              tvTemperatureMin.text = "${weekForcast.temperature_min.roundToInt()} °C"
              tvWindDirection.text = "${weekForcast.winddirection}°"
              tvWindSpeedMax.text = "${kmhWindMax.roundToInt()} Km/h"
              tvWindSpeedMin.text = "${kmhWindMin.roundToInt()} Km/h"

              if (weekForcast.pictocode == 1){
                  imgWeather.setImageResource(R.drawable.cloudy)
              }else if(weekForcast.pictocode == 2){
                  imgWeather.setImageResource(R.drawable.partly_cloudy)
              }

              when (weekForcast.pictocode) {
                  1 -> imgWeather.setImageResource(R.drawable.sunny)
                  2 -> imgWeather.setImageResource(R.drawable.partly_cloudy)
                  4 -> imgWeather.setImageResource(R.drawable.cloudy)
                  6 -> imgWeather.setImageResource(R.drawable.rain)
                  8 -> imgWeather.setImageResource(R.drawable.probability_rain)
                  16 -> imgWeather.setImageResource(R.drawable.partly_cloudy)

                  // Agrega más casos según sea necesario
                  else -> {
                      // Manejar el caso por defecto o agregar más lógica según sea necesario
                      // Por ejemplo, puedes establecer una imagen por defecto aquí
                      imgWeather.setImageResource(R.drawable.partly_cloudy)
                  }
              }
          }
        }
    }
}