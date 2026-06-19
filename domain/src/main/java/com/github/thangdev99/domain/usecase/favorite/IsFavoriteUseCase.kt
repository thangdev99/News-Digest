

package com.github.thangdev99.domain.usecase.favorite

import com.github.thangdev99.domain.model.News
import com.github.thangdev99.domain.repository.FavoriteRepository
import javax.inject.Inject

class IsFavoriteUseCase @Inject constructor(
    private val repository: FavoriteRepository
) {
    operator fun invoke(news: News) = repository.isFavorite(news)
}
