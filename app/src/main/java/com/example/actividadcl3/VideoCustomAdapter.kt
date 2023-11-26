package com.example.actividadcl3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView



class VideoCustomAdapter (private val context: Context, private val mList: List<VideoViewModel>): RecyclerView.Adapter<VideoCustomAdapter.ViewHolder>() {

    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val titulo0 : TextView = ItemView.findViewById(R.id.lbl_titulo0)
        val subtitulo0 : TextView = ItemView.findViewById(R.id.lbl_subtitulo0)
        val url0 :TextView = ItemView.findViewById(R.id.lbl_url0)
        val titulo : TextView = ItemView.findViewById(R.id.lbl_titulo)
        val subtitulo: TextView = ItemView.findViewById(R.id.lbl_subtitulo)
        val url: TextView = ItemView.findViewById(R.id.lbl_url)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclercl3, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.count();
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = mList[position]
        holder.titulo0.text = "Titulo"
        holder.subtitulo0.text = "Subtitulo"
        holder.url0.text = "URL"
        holder.titulo.text = itemViewModel.titulo
        holder.subtitulo.text = itemViewModel.subtitulo
        holder.url.text = itemViewModel.url

        holder.itemView.setOnClickListener {
            val intent = Intent(context, VideoActivity3::class.java)
            // Puedes pasar datos adicionales a la nueva actividad aquí si es necesario
            intent.putExtra("Dato1", itemViewModel.titulo)
            intent.putExtra("Dato2", itemViewModel.url)
            context.startActivity(intent)
        }

    }
}