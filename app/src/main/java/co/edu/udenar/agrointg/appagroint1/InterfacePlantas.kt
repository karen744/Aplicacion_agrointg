package co.edu.udenar.agrointg.appagroint1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfacePlantas {
    @GET("species-list")
    fun getSpeciesList(
        @Query("key") apiKey: String,
        @Query("q") query: String
    ): Call<List<Data>>


}