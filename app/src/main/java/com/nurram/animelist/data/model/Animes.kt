package com.nurram.animelist.data.model

import com.squareup.moshi.Json

data class Animes(
    var top: ArrayList<Anime>
) {
    data class Anime(
        @Json(name = "mal_id")
        var id: Int = 0,
        var rank: Int = 0,
        var title: String = "",
        var url: String = "",
        @Json(name = "image_url")
        var imageUrl: String = "",
        var type: String = "",
        var episodes: String = "",
        @Json(name = "start_date")
        var startDate: String = "",
        @Json(name = "end_date")
        var endDate: String = "",
        var score: Int = 0
    )
}