package com.example.actividadcl3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {
    lateinit var videoView : VideoView;
    var urlVideo: String = "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val btnRegresar: Button = findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener{
            val video = Intent(this, MainActivity::class.java)
            startActivity(video)

        };


        videoView = findViewById(R.id.vdVideoApi)
        val uri: Uri = Uri.parse(urlVideo)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)

        videoView.start()

    }

}