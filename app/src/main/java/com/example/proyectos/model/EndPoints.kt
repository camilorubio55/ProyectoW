package com.example.proyectos.model

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface EndPoints {

    @POST("codigophp/API2/Controller/GetAllProyecto.php")
    fun getList(): Call<ArrayList<Proyecto>>

}