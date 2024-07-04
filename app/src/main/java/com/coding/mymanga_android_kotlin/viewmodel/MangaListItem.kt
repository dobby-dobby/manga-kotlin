package com.coding.mymanga_android_kotlin.viewmodel

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.coding.domain.model.Manga

@Composable
fun MangaListItem(manga: Manga, onMangaClick: (Int) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onMangaClick(manga.id) }
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(manga.coverUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = manga.title, style = MaterialTheme.typography.titleMedium)
            Text(text = manga.author ?: "Unknown", style = MaterialTheme.typography.bodyMedium)
        }
    }
}