

package com.github.thangdev99.domain.usecase.favorite

import com.github.thangdev99.domain.repository.FavoriteRepository
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: FavoriteRepository
) {
    operator fun invoke() = repository.getFavorites()
}
