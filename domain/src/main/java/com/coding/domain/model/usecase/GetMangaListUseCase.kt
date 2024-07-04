package com.coding.domain.model.usecase

import com.coding.core.ulti.Resource
import com.coding.data.entity.MangaEntity
import com.coding.data.repository.MangaRepository
import com.coding.domain.model.Manga
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMangaListUseCase @Inject constructor(
    private val repository: MangaRepository
) {

    operator fun invoke(page: Int, limit: Int = 20): Flow<Resource<List<MangaEntity>>> = flow {
        try {
            emit(Resource.Loading())
            val mangaList = repository.getMangaList(page, limit)
            emit(mangaList)
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}