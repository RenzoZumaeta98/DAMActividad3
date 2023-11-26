package com.example.actividadcl3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class VideoActivity2 : AppCompatActivity() {
    lateinit var videoView : VideoView;
    var urlVideo: String = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video2)

        val btnRegresar: Button = findViewById(R.id.btnRegresar2);

        btnRegresar.setOnClickListener{
            val video = Intent(this, MainActivity::class.java)
            startActivity(video)

        };
        videoView = findViewById(R.id.vdVideoApi2)

        val uri: Uri = Uri.parse(urlVideo)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)

        videoView.start()

    }

}