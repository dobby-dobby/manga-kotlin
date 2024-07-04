package com.coding.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapters")
data class ChapterEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    @ColumnInfo(name = "manga_id")
    val mangaId: Int,
    val number: Int,
)
