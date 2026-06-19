package com.github.thangdev99.data.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: NewsEntity)

    @Delete
    suspend fun delete(news: NewsEntity)

    @Query("SELECT * FROM news")
    fun getAll(): Flow<List<NewsEntity>>

    @Query("SELECT EXISTS(SELECT * FROM news WHERE title = :title)")
    fun isFavorite(title: String): Flow<Boolean>

    @Query("SELECT * FROM news WHERE isNotified = 0 ORDER BY syncedAt DESC LIMIT :limit")
    suspend fun getNewArticlesToNotify(limit: Int = 5): List<NewsEntity>

    @Query("UPDATE news SET isNotified = 1 WHERE title = :title")
    suspend fun markAsNotified(title: String)

    @Query("SELECT COUNT(*) FROM news WHERE isNotified = 0")
    suspend fun getNewArticlesCount(): Int
}
