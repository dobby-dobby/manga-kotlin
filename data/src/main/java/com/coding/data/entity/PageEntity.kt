package com.coding.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pages")
data class PageEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "chapter_id") // Đặt tên cột cho chapterId
    val chapterId: Int,
    val imageUrl: String,
    val pageNumber: Int
)
