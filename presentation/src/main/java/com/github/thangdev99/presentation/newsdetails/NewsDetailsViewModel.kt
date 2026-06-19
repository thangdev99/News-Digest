package com.github.thangdev99.presentation.newsdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.github.thangdev99.domain.usecase.favorite.AddFavoriteUseCase
import com.github.thangdev99.domain.usecase.favorite.IsFavoriteUseCase
import com.github.thangdev99.domain.usecase.favorite.RemoveFavoriteUseCase
import com.github.thangdev99.presentation.model.NewsUiModel
import com.github.thangdev99.presentation.model.NewsUiModel.Companion.toNews
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase,
    private val isFavoriteUseCase: IsFavoriteUseCase
) : ViewModel() {
    fun addFavorite(news: NewsUiModel) {
        viewModelScope.launch {
            addFavoriteUseCase(news.toNews())
        }
    }

    fun removeFavorite(news: NewsUiModel) {
        viewModelScope.launch {
            removeFavoriteUseCase(news.toNews())
        }
    }

    fun isFavorite(news: NewsUiModel) = isFavoriteUseCase(news.toNews())
}
