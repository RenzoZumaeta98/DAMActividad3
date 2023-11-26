package com.example.actividadcl3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

class VideoActivity3 : AppCompatActivity() {
    lateinit var videoView : VideoView;
    var urlVideo: String = "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video3)

        val btnRegresar: Button = findViewById(R.id.btnRegresar);
        val txtTitulo: TextView = findViewById(R.id.textViewVideo3)
        val datoTitulo = intent.getStringExtra("Dato1")
        val datoUrl :String = intent.getStringExtra("Dato2").toString()
        txtTitulo.text = datoTitulo

        btnRegresar.setOnClickListener{
            val video = Intent(this, MainActivity::class.java)
            startActivity(video)

        };




        videoView = findViewById(R.id.vdVideoApi3)
        val uri: Uri = Uri.parse(datoUrl)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)

        videoView.start()

    }

}