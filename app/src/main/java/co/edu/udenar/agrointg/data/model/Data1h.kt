package co.edu.udenar.agrointg.data.model

data class Data1h(
    val convective_precipitation: List<Double>,
    val felttemperature: List<Double>,
    val isdaylight: List<Int>,
    val pictocode: List<Int>,
    val precipitation: List<Double>,
    val precipitation_probability: List<Int>,
    val rainspot: List<String>,
    val relativehumidity: List<Int>,
    val sealevelpressure: List<Double>,
    val snowfraction: List<Double>,
    val temperature: List<Double>,
    val time: List<String>,
    val uvindex: List<Int>,
    val winddirection: List<Int>,
    val windspeed: List<Double>
)