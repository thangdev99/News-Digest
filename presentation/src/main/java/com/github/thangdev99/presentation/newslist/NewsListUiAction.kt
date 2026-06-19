package com.github.thangdev99.presentation.newslist

import com.github.thangdev99.presentation.model.NewsUiModel

sealed interface NewsListUiAction {

    data class NavigateToNewsDetails(val news: NewsUiModel) : NewsListUiAction

    data object NavigateToSearchNews : NewsListUiAction

    data object ShowCountriesDialog : NewsListUiAction

    data object DismissCountriesDialog : NewsListUiAction

    data class SelectCountry(val country: String) : NewsListUiAction
}
