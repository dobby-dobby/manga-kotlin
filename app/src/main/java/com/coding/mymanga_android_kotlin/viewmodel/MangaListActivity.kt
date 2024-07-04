package com.coding.mymanga_android_kotlin.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MangaListViewModel by viewModels()
            val state by viewModel.mangaListState.collectAsState()

            MangaListScreen(state = state, onRetryClick = { viewModel.getMangaList() })
        }
    }
}