package com.example.proyectos.model

import android.app.PendingIntent.getActivity
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.Exception

class ProyectoRepositorioImpl() {

    private var proyectos = MutableLiveData<List<Proyecto>>()

    fun llamarProyectosAPI(){


        solicitudOkHTTP("http://127.0.0.1/codigophp/API2/Controller/GetAllProyecto.php")

        /*println("--- Error")

        val retrofit = Retrofit.Builder()
            .baseUrl("http://127.0.0.1:80/codigophp/API2/Controller/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val endPoint = retrofit.create(EndPoints::class.java)

        val call = endPoint.getList()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                println("--- Error1")
                println("ola  ${t.stackTrace.toString()}")
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                println("--- Error2")
                if(response?.isSuccessful)
                    Log.w("error", response.message())

            }
        })*/
    }



    fun obtenerProyectos(): MutableLiveData<List<Proyecto>>{
        return proyectos
    }

    fun solicitudOkHTTP(url: String){
        val cliente = OkHttpClient()
        val solicitud = okhttp3.Request.Builder().url(url).build()

        cliente.newCall(solicitud).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                println("--- Error1")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                println("--- Error2")
                val result = response.body()?.string()

                try {
                    Log.d("SolicitudHTTP",result)
                }catch (e: Exception){
                    e.stackTrace
                }
                //this@ProyectoRepositorioImpl.run
            }

        })
    }

}