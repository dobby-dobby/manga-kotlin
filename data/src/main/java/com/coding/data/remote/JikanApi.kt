package com.coding.data.remote

import com.coding.data.model.MangaTopResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JikanApi {
    @GET("top/manga")
    suspend fun getTopManga(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 20,
    ): Response<MangaTopResponse>
}