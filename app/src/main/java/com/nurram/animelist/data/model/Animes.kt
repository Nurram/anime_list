package com.nurram.animelist.data.model

import com.google.gson.annotations.SerializedName

data class Animes(
    var top: ArrayList<Anime>
) {
    data class Anime(
        @SerializedName("mal_id")
        var id: Int = 0,
        var rank: Int = 0,
        var title: String = "",
        var url: String = "",
        @SerializedName("image_url")
        var imageUrl: String = "",
        var type: String = "",
        var episodes: Int = 0,
        @SerializedName("start_date")
        var startDate: String = "",
        @SerializedName("end_date")
        var endDate: String = "",
        var score: Double = 0.0
    )
}