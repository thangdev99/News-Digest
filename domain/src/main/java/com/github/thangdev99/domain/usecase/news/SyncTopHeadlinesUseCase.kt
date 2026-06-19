package com.github.thangdev99.domain.usecase.news

import com.github.thangdev99.domain.model.News
import com.github.thangdev99.domain.repository.NewsRepository
import javax.inject.Inject

class SyncTopHeadlinesUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(
        country: String = "us",
        category: String? = null
    ): Result<List<News>> = repository.syncTopHeadlines(country, category)
}

