package com.nurram.animelist.ui.main

import com.nurram.animelist.data.network.ApiService

class MainRepo(private val apiService: ApiService) {
    fun getTopAnimes() = apiService.getTopAnimes()
}