package com.coding.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "manga")
data class MangaEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val author: String,
    val coverUrl: String,
    val description: String? = null,
    val genres: List<String>? = null,
    val status: String? = null,
    val rating: Double? = null
)
