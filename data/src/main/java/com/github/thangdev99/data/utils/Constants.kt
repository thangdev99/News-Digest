

package com.github.thangdev99.data.utils

import androidx.datastore.preferences.core.intPreferencesKey

object Constants {
    const val PAGE_SIZE = 10
    const val BASE_URL = "https://newsapi.org/v2/"
    const val DATABASE_NAME = "news.db"
    internal const val NEWS_TABLE_NAME = "news"
    const val NEWS_APP_PREFERENCES = "news_app_preferences"
    val THEME_OPTIONS = intPreferencesKey(name = "theme_option")
    val LANGUAGE_KEY = intPreferencesKey(name = "language_key")

    //WorkManager and Notification
    const val UNIQUE_WORK_NAME = "newsAppPeriodicWork"
    const val MORNING_UPDATE_TIME = 5
    const val NOTIFICATION_ID = 1
    const val NOTIFICATION_CHANNEL_ID = "news_channel"
    const val NOTIFICATION_CHANNEL_NAME = "News"
    const val NOTIFICATION_CONTENT_TITLE = "News"
    const val NOTIFICATION_CONTENT_TEXT = "Check out the latest news ..."
}
