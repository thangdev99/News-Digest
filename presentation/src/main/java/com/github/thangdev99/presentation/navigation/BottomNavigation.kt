package com.github.thangdev99.presentation.navigation

import com.github.thangdev99.designsystem.R

enum class BottomNavigation(
    val label: Int,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val route: Any,
) {
    News(
        label = com.github.thangdev99.presentation.R.string.news,
        selectedIcon = R.drawable.ic_home_filled,
        unselectedIcon = R.drawable.ic_home_outlined,
        route = Destinations.NewsList
    ),
    Favorites(
        label = com.github.thangdev99.presentation.R.string.favorites,
        selectedIcon = R.drawable.ic_favorite_filled,
        unselectedIcon = R.drawable.ic_favorite_outlined,
        route = Destinations.Favorites
    ),
    Settings(
        label = com.github.thangdev99.presentation.R.string.settings,
        selectedIcon = R.drawable.ic_settings_filled,
        unselectedIcon = R.drawable.ic_settings_outlined,
        route = Destinations.Settings
    )
}
