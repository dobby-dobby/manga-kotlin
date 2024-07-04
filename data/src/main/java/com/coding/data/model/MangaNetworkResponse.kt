package com.coding.data.model

import com.google.gson.annotations.SerializedName

data class MangaNetworkResponse(
    @SerializedName("mal_id") val malId: Int,
    val title: String,
    @SerializedName("image_url") val imageUrl: String,
    val author: String
)