package com.coding.data.mapper

import com.coding.data.entity.MangaEntity
import com.coding.data.model.MangaNetworkResponse

fun MangaNetworkResponse.toDomainModel(): MangaEntity {
    return MangaEntity(
        id = malId,
        title = title,
        author = author, // Assuming Jikan API provides author info in the details endpoint
        coverUrl = imageUrl,
        description = null, //  You'll fetch these details in a separate API call later
        genres = null,
        status = null
    )
}