package com.example.actividadcl3

import retrofit2.Response
import retrofit2.http.GET

interface VideoAPI{

    @GET("mocks/4ec29416-9549-4452-82d8-902ab23ed03e/actividadcl3/videos")
    suspend fun getVideos(): Response<APIDetalle>
}