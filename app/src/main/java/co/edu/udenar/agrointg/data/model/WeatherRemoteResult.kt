package co.edu.udenar.agrointg.data.model

data class WeatherRemoteResult(
    val data_1h: Data1h,
    val data_day: DataDay,
    val metadata: Metadata,
    val units: Units
)