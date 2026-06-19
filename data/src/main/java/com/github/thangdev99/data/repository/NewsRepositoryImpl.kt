package com.github.thangdev99.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.thangdev99.data.cache.NewsDao
import com.github.thangdev99.data.cache.NewsEntity
import com.github.thangdev99.data.network.NewsApi
import com.github.thangdev99.data.network.dto.NewsResponseDto.Companion.toNews
import com.github.thangdev99.data.paging.NewsPagingSource
import com.github.thangdev99.data.utils.Constants.PAGE_SIZE
import com.github.thangdev99.domain.model.News
import com.github.thangdev99.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : NewsRepository {
    override fun getNews(
        country: String?,
        category: String?,
        searchQuery: String?
    ): Flow<PagingData<News>> = Pager(
        config =
        PagingConfig(
            pageSize = PAGE_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            NewsPagingSource(
                newsApi = newsApi,
                country = country,
                category = category,
                searchQuery = searchQuery
            )
        }
    ).flow

    override suspend fun syncTopHeadlines(
        country: String,
        category: String?
    ): Result<List<News>> = try {
        val response = newsApi.fetchNews(
            country = country,
            category = category,
            pageSize = PAGE_SIZE,
            page = 1,
            searchQuery = null
        )
        
        val newsList = response.articles.map { it.toNews() }
        
        // Save articles to database
        newsList.forEach { news ->
            val entity = NewsEntity(
                title = news.title,
                description = news.description,
                content = news.content,
                imageUrl = news.imageUrl,
                source = news.source,
                publishedAt = news.publishedAt,
                author = news.author,
                url = news.url,
                syncedAt = System.currentTimeMillis(),
                isNotified = false
            )
            newsDao.insert(entity)
        }
        
        Result.success(newsList)
    } catch (e: Exception) {
        Result.failure(e)
    }
}
