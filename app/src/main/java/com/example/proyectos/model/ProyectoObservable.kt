package com.example.proyectos.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class ProyectoObservable: BaseObservable() {

    private var proyectoRepositorioImpl: ProyectoRepositorioImpl = ProyectoRepositorioImpl()

    fun llamarProyectos(){
        proyectoRepositorioImpl?.llamarProyectosAPI()
    }

    fun obtenerProyectos(): MutableLiveData<ArrayList<Proyecto>> {
        return proyectoRepositorioImpl.obtenerProyectos()
    }
}