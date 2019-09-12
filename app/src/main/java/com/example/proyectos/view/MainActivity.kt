package com.example.proyectos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.proyectos.R
import com.example.proyectos.databinding.ActivityMainBinding
import com.example.proyectos.model.Proyecto
import com.example.proyectos.viewmodel.ProyectoViewModel

class MainActivity : AppCompatActivity() {

    private var proyectoViewModel: ProyectoViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        setupBindings(savedInstanceState)
    }

    fun setupBindings(savedInstanceState: Bundle?){
        var activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        proyectoViewModel = ViewModelProviders.of(this).get(ProyectoViewModel::class.java)
        activityMainBinding.setModel(proyectoViewModel)
        setupListUpdate()
    }

    fun setupListUpdate(){
        proyectoViewModel?.llamarProyectos()
        proyectoViewModel?.obtenerProyectos()?.observe(this, Observer {proyecto: List<Proyecto> ->
            Log.w("PROYECTO",proyecto.get(0).titulo)
        })

    }
}
