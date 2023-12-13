package co.edu.udenar.agrointg.data.model

sealed class WeekForcast {
    data class DayForcast (
        val felttemperature_max: Double,
        val felttemperature_min: Double,
        val humiditygreater90_hours: Double,
        val precipitation_probability: Int,
        val relativehumidity_max: Int,
        val relativehumidity_mean: Int,
        val relativehumidity_min: Int,
        val temperature_max: Double,
        val temperature_mean: Double,
        val temperature_min: Double,
        val time: String,
        val winddirection: Int,
        val windspeed_max: Double,
        val windspeed_mean: Double,
        val windspeed_min: Double,
        val pictocode: Int
    ) : WeekForcast()
}