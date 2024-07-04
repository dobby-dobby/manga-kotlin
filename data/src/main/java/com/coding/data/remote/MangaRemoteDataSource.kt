package com.coding.data.remote

import com.coding.core.ulti.Resource
import com.coding.data.model.MangaNetworkResponse
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface MangaRemoteDataSource {
    suspend fun getMangaList(page: Int, limit: Int = 20): Resource<List<MangaNetworkResponse>>
}


class MangaRemoteDataSourceImpl @Inject constructor(
    private val jikanApi: JikanApi
) : MangaRemoteDataSource {

    override suspend fun getMangaList(page: Int, limit: Int): Resource<List<MangaNetworkResponse>> = try {
        val response = jikanApi.getTopManga(page, limit)
        if (response.isSuccessful && response.body() != null) {
            Resource.Success(response.body()!!.data)
        } else {
            Resource.Error(response.message() ?: "Unknown error occurred")
        }
    } catch (e: IOException) {
        Resource.Error("Couldn't reach server. Check your internet connection.")
    } catch (e: HttpException) {
        Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
    }
}