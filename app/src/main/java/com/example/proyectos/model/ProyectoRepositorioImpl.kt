package com.example.proyectos.model

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.JsonElement

class ProyectoRepositorioImpl() {

    private var proyectos = MutableLiveData<List<Proyecto>>()

    fun llamarProyectosAPI(){

        var proyectosList: ArrayList<Proyecto>? = ArrayList<Proyecto>()
        //var proyect: ArrayList<Proyecto> = ArrayList<Proyecto>()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.71:81/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val endPoint = retrofit.create(EndPoints::class.java)

        endPoint.getList().enqueue(object : Callback<ArrayList<Proyecto>> {
            override fun onFailure(call: Call<ArrayList<Proyecto>>, t: Throwable) {
                d("hola", "onFailure")
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ArrayList<Proyecto>>, response: Response<ArrayList<Proyecto>>) {
                val proyect = response.body()
                println("--- ola ${proyect?.get(0)?.success}")
                //proyectosList?.add(proyect)
                proyectos.value = proyect
                println("--- ola2 ${proyectos.value?.get(0)?.success}")

            }

        })
    }

    fun obtenerProyectos(): MutableLiveData<List<Proyecto>>{
        return proyectos
    }
}