package com.github.thangdev99.presentation.search

import androidx.paging.PagingData
import com.github.thangdev99.presentation.model.NewsUiModel
import kotlinx.coroutines.flow.Flow

data class SearchNewsUiState(
    val searchValue: String = "",
    val news: Flow<PagingData<NewsUiModel>>? = null
)
