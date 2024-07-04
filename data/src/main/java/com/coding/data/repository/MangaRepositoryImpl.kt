package com.coding.data.repository

import com.coding.core.ulti.Resource
import com.coding.data.entity.MangaEntity
import com.coding.data.mapper.toDomainModel
import com.coding.data.remote.MangaRemoteDataSourceImpl
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(
    private val remoteDataSource: MangaRemoteDataSourceImpl
) : MangaRepository {

    override suspend fun getMangaList(page: Int, limit: Int): Resource<List<MangaEntity>> {
        return when (val response = remoteDataSource.getMangaList(page, limit)) {
            is Resource.Success -> Resource.Success(response.data.map { it.toDomainModel() })
            is Resource.Error -> response // Return the error directly
            is Resource.Loading -> Resource.Loading()
        }
    }
}