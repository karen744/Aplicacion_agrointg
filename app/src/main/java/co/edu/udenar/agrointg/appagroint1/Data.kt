package co.edu.udenar.agrointg.appagroint1

data class Data(
    val common_name: String,
    val cycle: String,
    val default_image: DefaultImage,
    val id: Int,
    val other_name: List<Any>,
    val scientific_name: List<String>,
    val sunlight: String,
    val watering: String
)