package com.github.thangdev99.domain.repository

import com.github.thangdev99.domain.model.News
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun addFavorite(news: News)

    suspend fun removeFavorite(news: News)

    fun getFavorites(): Flow<List<News>>

    fun isFavorite(news: News): Flow<Boolean>
}
