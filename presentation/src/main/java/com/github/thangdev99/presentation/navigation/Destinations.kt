package com.github.thangdev99.presentation.navigation

import android.annotation.SuppressLint
import com.github.thangdev99.presentation.model.NewsUiModel
import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object NewsList

    @Serializable
    object SearchNews

    @SuppressLint("UnsafeOptInUsageError")
    @Serializable
    data class NewsDetails(val news: NewsUiModel)

    @Serializable
    data object Favorites

    @Serializable
    object Settings

    @Serializable
    object Language
}
