package com.coding.data.repository

import com.coding.core.ulti.Resource
import com.coding.data.entity.MangaEntity

interface MangaRepository {

    suspend fun getMangaList(page: Int, limit: Int = 20): Resource<List<MangaEntity>>
}