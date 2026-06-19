

package com.github.thangdev99.domain.usecase.news

import com.github.thangdev99.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(
        country: String?,
        category: String?
    ) = repository.getNews(
        country = country,
        category = category,
        searchQuery = null
    )
}
