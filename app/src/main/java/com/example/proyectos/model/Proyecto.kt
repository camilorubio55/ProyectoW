package com.example.proyectos.model

import com.google.gson.JsonObject
import java.io.Serializable

class Proyecto(proyectoJson: JsonObject?) : Serializable {

    lateinit var proyectoid: String
    lateinit var titulo: String
    lateinit var descripcion: String
    lateinit var fecentrega: String
    lateinit var fecestimada: String
    lateinit var horas: String
    lateinit var usuid: String

    init {
        try {
            proyectoid = proyectoJson!!.get(proyectoid).asString
            titulo = proyectoJson!!.get(titulo).asString
            descripcion = proyectoJson!!.get(descripcion).asString
            fecentrega = proyectoJson!!.get(fecentrega).asString
            fecestimada = proyectoJson!!.get(fecestimada).asString
            horas = proyectoJson!!.get(horas).asString
            usuid = proyectoJson!!.get(usuid).asString
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    /*companion object {

    }*/
}