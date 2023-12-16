package co.edu.udenar.agrointg.appagroint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.udenar.agrointg.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Plantas : AppCompatActivity() {

    lateinit var rvMain: RecyclerView
    lateinit var myAdapter: PlantasAdapter

    var BASE_URL = "https://www.fruityvice.com/api/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plantas)

        rvMain = findViewById(R.id.recycler_view)

        rvMain.layoutManager = LinearLayoutManager(this)

        myAdapter = PlantasAdapter(baseContext, emptyList()) // Inicializa con una lista vacía
        rvMain.adapter = myAdapter

        getAllData()
    }

    private fun getAllData() {

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InterfacePlantas::class.java)

        var retroData = retrofit.getData()

        retroData.enqueue(object : Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                var data = response.body()!!

                myAdapter = PlantasAdapter(baseContext, data)

                rvMain.adapter = myAdapter

                Log.d("data", data.toString())
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

            }

        })
    }
}