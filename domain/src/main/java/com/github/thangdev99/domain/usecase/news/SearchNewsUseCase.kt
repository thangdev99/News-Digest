

package com.github.thangdev99.domain.usecase.news

import com.github.thangdev99.domain.repository.NewsRepository
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(searchQuery: String) =
        repository.getNews(
            country = null,
            category = null,
            searchQuery = searchQuery
        )
}
