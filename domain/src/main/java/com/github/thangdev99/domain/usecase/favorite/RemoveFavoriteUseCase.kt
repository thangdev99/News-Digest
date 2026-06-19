

package com.github.thangdev99.domain.usecase.favorite

import com.github.thangdev99.domain.model.News
import com.github.thangdev99.domain.repository.FavoriteRepository
import javax.inject.Inject

class RemoveFavoriteUseCase @Inject constructor(
    private val repository: FavoriteRepository
) {
    suspend operator fun invoke(news: News) = repository.removeFavorite(news)
}
