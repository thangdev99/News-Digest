package com.github.thangdev99.domain.repository

import androidx.paging.PagingData
import com.github.thangdev99.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(
        country: String?,
        category: String?,
        searchQuery: String?
    ): Flow<PagingData<News>>

    suspend fun syncTopHeadlines(
        country: String,
        category: String?
    ): Result<List<News>>
}
