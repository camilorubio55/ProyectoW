package com.example.proyectos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectos.R
import com.example.proyectos.model.Proyecto
import com.example.proyectos.model.ProyectoObservable
import com.example.proyectos.view.RecyclerProyectoAdapter
import java.text.FieldPosition

class ProyectoViewModel: ViewModel() {

    private var proyectoObservable: ProyectoObservable = ProyectoObservable()
    private var recyclerProyectoAdapter: RecyclerProyectoAdapter? = null

    fun llamarProyectos(){
        proyectoObservable?.llamarProyectos()
    }

    fun obtenerProyectos(): MutableLiveData<ArrayList<Proyecto>> {
        return  proyectoObservable.obtenerProyectos()
    }

    fun setProyectosInRecyclesAdapter(proyectos: ArrayList<Proyecto>){
        recyclerProyectoAdapter?.setProyectoList(proyectos)
        recyclerProyectoAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerProyectosAdapter (): RecyclerProyectoAdapter?{
        recyclerProyectoAdapter = RecyclerProyectoAdapter(this, R.layout.tarjetaproyecto)
        //println("---recyclerdata  ${recyclerProyectoAdapter.toString()}")
        return recyclerProyectoAdapter
    }

    fun getProyectoAt(position: Int): Proyecto?{
        var proyectos: ArrayList<Proyecto>? = proyectoObservable.obtenerProyectos().value
        return proyectos?.get(position)
    }
}