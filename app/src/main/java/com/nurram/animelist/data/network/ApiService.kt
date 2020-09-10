package com.nurram.animelist.data.network

import com.nurram.animelist.data.model.Animes
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/v3/top/anime")
    fun getTopAnimes(): Call<Animes>
}