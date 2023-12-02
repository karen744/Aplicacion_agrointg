package co.edu.udenar.agrointg.data.model

data class Metadata(
    val height: Int,
    val latitude: Double,
    val longitude: Double,
    val modelrun_updatetime_utc: String,
    val modelrun_utc: String,
    val name: String,
    val timezone_abbrevation: String,
    val utc_timeoffset: Double
)