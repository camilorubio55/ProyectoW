package com.example.proyectos.model

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProyectoRepositorioImpl() {

    private var proyectos = MutableLiveData<ArrayList<Proyecto>>()

    fun llamarProyectosAPI(){

        var mAPIService: APIService?

        mAPIService = APIUtils.apiService

        try {
            var jsonObject: JsonObject = JsonObject()
            jsonObject.addProperty("usuid","1")
            println("-- respuesta ${jsonObject}")


            mAPIService!!.parametrosGetAllProyectos(jsonObject).enqueue(object : Callback<ArrayList<Proyecto>> {
                override fun onFailure(call: Call<ArrayList<Proyecto>>, t: Throwable) {
                    d("--- respuestaonF", "onFailure")
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<ArrayList<Proyecto>>, response: Response<ArrayList<Proyecto>>) {
                    val proyect = response.body()
                    println("--- respuestaonR ${proyect.toString()}")
                    proyectos.value = proyect
                }
            })
        }catch (e: Exception){
            e.stackTrace
        }
    }

    fun obtenerProyectos(): MutableLiveData<ArrayList<Proyecto>>{
        return proyectos
    }
}