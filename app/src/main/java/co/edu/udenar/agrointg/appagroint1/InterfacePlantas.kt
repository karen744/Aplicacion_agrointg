package co.edu.udenar.agrointg.appagroint1

import retrofit2.Call
import retrofit2.http.GET

interface InterfacePlantas {
    @GET("fruit/all")
    fun getData(): Call<List<UsersItem>>

    //@GET("species-list")
    //fun getSpeciesList(
    //    @Query("key") apiKey: String,
    //    @Query("q") query: String
    //): Call<List<Data>>


}