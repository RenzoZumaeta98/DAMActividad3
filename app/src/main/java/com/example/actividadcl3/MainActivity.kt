package com.example.actividadcl3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val VideosAPI = RetrofitHelper.getRetrofitInstance().create(VideoAPI::class.java)

        val RecyclerActividad: RecyclerView = findViewById(R.id.rv_cl3)
        RecyclerActividad.layoutManager = LinearLayoutManager(this)

        val btnVideo: Button = findViewById(R.id.btnVideo);
        val btnVideo2: Button = findViewById(R.id.btnVideo2);

        val data = ArrayList<VideoViewModel>();

        // Almacena una referencia al contexto de la actividad
        val context = this

        GlobalScope.launch {
            val result = VideosAPI.getVideos()

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            for (i in 1..12) {
                val titulo = result.body()?.videos?.get(i)?.title.toString()
                val subtitulo = result.body()?.videos?.get(i)?.subtitle.toString()
                val url = result.body()?.videos?.get(i)?.sources?.get(0).toString()

                data.add(VideoViewModel(titulo, subtitulo, url))

            }

            runOnUiThread{
                val adapter = VideoCustomAdapter(context ,data)
                RecyclerActividad.adapter = adapter

            }


        }

        btnVideo.setOnClickListener{
            val video = Intent(this, VideoActivity::class.java)
            startActivity(video)

        };

        btnVideo2.setOnClickListener{
            val video = Intent(this, VideoActivity2::class.java)
            startActivity(video)

        };
    }
}