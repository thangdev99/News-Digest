package com.github.thangdev99.data.repository

import com.github.thangdev99.domain.model.News
import com.github.thangdev99.domain.repository.FavoriteRepository
import com.github.thangdev99.data.cache.NewsDao
import com.github.thangdev99.data.cache.NewsEntity.Companion.toEntity
import com.github.thangdev99.data.cache.NewsEntity.Companion.toNews
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
) : FavoriteRepository {
    override suspend fun addFavorite(news: News) {
        newsDao.insert(news.toEntity())
    }

    override suspend fun removeFavorite(news: News) {
        newsDao.delete(news.toEntity())
    }

    override fun getFavorites(): Flow<List<News>> = newsDao.getAll().map { newsList ->
        newsList.map {
            it.toNews()
        }
    }

    override fun isFavorite(news: News): Flow<Boolean> = newsDao.isFavorite(news.title)
}
