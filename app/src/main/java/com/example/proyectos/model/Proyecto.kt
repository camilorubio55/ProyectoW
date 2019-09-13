package com.example.proyectos.model

import com.google.gson.JsonObject
import java.io.Serializable

class Proyecto(proyectoJson: JsonObject?) : Serializable {

    lateinit var success: String
    lateinit var mensaje: String
    lateinit var proyectoid: String
    lateinit var titulo: String
    lateinit var descripcion: String
    lateinit var fecentrega: String
    lateinit var fecestimada: String
    lateinit var horas: String
    lateinit var usuid: String

    init {
        try {
            success = proyectoJson!!.get(SUCCESS).asString
            mensaje = proyectoJson!!.get(MENSAJE).asString
            proyectoid = proyectoJson!!.get(PROYECTOID).asString
            titulo = proyectoJson!!.get(TITULO).asString
            descripcion = proyectoJson!!.get(DESCRIPCION).asString
            fecentrega = proyectoJson!!.get(FECENTREGA).asString
            fecestimada = proyectoJson!!.get(FECESTIMADA).asString
            horas = proyectoJson!!.get(HORAS).asString
            usuid = proyectoJson!!.get(USUID).asString
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    companion object {
        private val SUCCESS      = "success"
        private val MENSAJE      = "mensaje"
        private val PROYECTOID   = "proyectoid"
        private val TITULO       = "titulo"
        private val DESCRIPCION  = "descripcion"
        private val FECENTREGA   = "fecentrega"
        private val FECESTIMADA  = "fecestimada"
        private val HORAS        = "horas"
        private val USUID        = "usuid"
    }
}