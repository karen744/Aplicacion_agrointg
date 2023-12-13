package co.edu.udenar.agrointg.data

import co.edu.udenar.agrointg.data.model.WeatherRemoteResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("packages/basic-1h_basic-day?format=json")
    suspend fun listPopularMovies(
        @Query("apikey") apiKey:String,
        @Query("lat") lat:String,
        @Query("lon") lon:String
    ) : WeatherRemoteResult


    object RetrofitServiceFactory{
        fun makeRetrofitService(): RetrofitService{
            return Retrofit.Builder().baseUrl("https://my.meteoblue.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitService::class.java)
        }
    }
}