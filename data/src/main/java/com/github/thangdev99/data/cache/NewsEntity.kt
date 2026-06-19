package com.github.thangdev99.data.cache

import androidx.room.Entity
import com.github.thangdev99.domain.model.News
import com.github.thangdev99.data.utils.Constants.NEWS_TABLE_NAME

@Entity(tableName = NEWS_TABLE_NAME, primaryKeys = ["title"])
data class NewsEntity(
    val title: String,
    val description: String,
    val content: String,
    val imageUrl: String,
    val source: String,
    val publishedAt: String,
    val author: String,
    val url: String,
    val syncedAt: Long = System.currentTimeMillis(),
    val isNotified: Boolean = false
) {
    companion object {
        fun News.toEntity(): NewsEntity = NewsEntity(
            title = title,
            description = description,
            content = content,
            imageUrl = imageUrl,
            source = source,
            publishedAt = publishedAt,
            author = author,
            url = url
        )

        fun NewsEntity.toNews(): News = News(
            title = title,
            description = description,
            content = content,
            imageUrl = imageUrl,
            source = source,
            publishedAt = publishedAt,
            author = author,
            url = url
        )
    }
}
