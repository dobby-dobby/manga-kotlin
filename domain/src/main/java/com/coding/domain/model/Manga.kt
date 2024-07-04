package com.coding.domain.model

data class Manga(
    val id: Int,
    val title: String,
    val author: String,
    val coverUrl: String,
    val description: String? = null,
    val genres: List<String>? = null,
    val status: String? = null,
    val rating: Double? = null,
    val chapters: List<Chapter>? = null
)