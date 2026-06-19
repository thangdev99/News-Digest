package com.github.thangdev99.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.github.thangdev99.presentation.favorites.FavoritesScreen
import com.github.thangdev99.presentation.language.LanguageScreen
import com.github.thangdev99.presentation.model.NewsUiModel
import com.github.thangdev99.presentation.newsdetails.NewsDetailsScreen
import com.github.thangdev99.presentation.newslist.NewsListScreen
import com.github.thangdev99.presentation.search.SearchNewsScreen
import com.github.thangdev99.presentation.settings.SettingsScreen
import kotlin.reflect.typeOf

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destinations.NewsList
    ) {
        composable<Destinations.NewsList> {
            NewsListScreen(
                navController = navController
            )
        }

        composable<Destinations.NewsDetails>(
            typeMap = mapOf(typeOf<NewsUiModel>() to NewsUiModelParameterType)
        ) { backStackEntry ->
            val news = backStackEntry.toRoute<Destinations.NewsDetails>().news
            NewsDetailsScreen(
                news = news,
                navController = navController
            )
        }

        composable<Destinations.SearchNews> {
            SearchNewsScreen(
                navController = navController
            )
        }

        composable<Destinations.Favorites> {
            FavoritesScreen(
                navController = navController
            )
        }

        composable<Destinations.Settings> {
            SettingsScreen(
                navController = navController
            )
        }

        composable<Destinations.Language> {
            LanguageScreen(
                navController = navController
            )
        }
    }
}
