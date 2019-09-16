package com.example.proyectos.model

import com.google.gson.JsonObject
import java.io.Serializable

class Proyecto() : Serializable {

    var success: String = ""
    var mensaje: String = ""
    var proyectoid: String = ""
    var titulo: String = ""
    var descripcion: String = ""
    var fecentrega: String = ""
    var fecestimada: String = ""
    var horas: String = ""
    var usuid: String = ""
}