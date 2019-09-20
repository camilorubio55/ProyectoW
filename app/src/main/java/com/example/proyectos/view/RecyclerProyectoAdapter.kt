package com.example.proyectos.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.proyectos.BR
import com.example.proyectos.R
import com.example.proyectos.model.Proyecto
import com.example.proyectos.viewmodel.ProyectoViewModel


class RecyclerProyectoAdapter(var proyectoViewModel: ProyectoViewModel, var resource: Int) : RecyclerView.Adapter<RecyclerProyectoAdapter.TarjetaProyectoHolder>() {

    var proyectos: ArrayList<Proyecto>? = null

    fun setProyectoList(proyectos: ArrayList<Proyecto>){
        this.proyectos = proyectos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaProyectoHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return TarjetaProyectoHolder(binding)
    }

    override fun getItemCount(): Int {
        return  proyectos?.size ?: 0
    }

    override fun onBindViewHolder(holder: TarjetaProyectoHolder, position: Int) {
        holder.setDataTarjeta(proyectoViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int): Int{
        return resource
    }

    class TarjetaProyectoHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private var binding: ViewDataBinding? = null
        //private var listener: View.ClickListener? = null

        init {
            this.binding = binding
        }

        fun setDataTarjeta(proyectoViewModel: ProyectoViewModel, position: Int){
            binding?.setVariable(BR.model, proyectoViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }

        override fun onClick(p0: View?) {
            if(p0?.id == R.id.tarjeta)
                Log.e("Error","--iguales")
            //println("-- son iguales")

            val context = p0?.context
            val mostrardetalle = Intent(context, DetalleProyectoActivity::class.java)
            mostrardetalle.putExtra("proyecto","ko")
            context?.startActivity(mostrardetalle)
        }

    }

}