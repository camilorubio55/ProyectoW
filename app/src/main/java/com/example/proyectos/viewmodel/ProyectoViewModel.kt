package com.example.proyectos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectos.model.Proyecto
import com.example.proyectos.model.ProyectoObservable

class ProyectoViewModel: ViewModel() {

    private var proyectoObservable: ProyectoObservable = ProyectoObservable()

    fun llamarProyectos(){
        proyectoObservable?.llamarProyectos()
    }

    fun obtenerProyectos(): MutableLiveData<List<Proyecto>> {
        return  proyectoObservable.obtenerProyectos()
    }
}