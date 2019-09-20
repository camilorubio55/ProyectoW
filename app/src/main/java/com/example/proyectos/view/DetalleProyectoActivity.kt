package com.example.proyectos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectos.R
import com.example.proyectos.model.Proyecto

class DetalleProyectoActivity : AppCompatActivity() {

    private var proyectoSelected: Proyecto? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_proyecto)

        proyectoSelected = intent.getSerializableExtra("proyecto") as Proyecto
    }
}
