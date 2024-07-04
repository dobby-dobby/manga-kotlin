package com.coding.domain.model

data class Chapter(
    val id: Int,
    val title: String,
    val mangaId: Int, // ID của manga mà chương này thuộc về
    val number: Int, // Số thứ tự của chương
    val pages: List<Page>? = null // Danh sách các trang trong chương (có thể null)
)