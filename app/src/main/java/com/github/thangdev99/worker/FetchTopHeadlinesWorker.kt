package com.github.thangdev99.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.github.thangdev99.domain.usecase.news.SyncTopHeadlinesUseCase
import com.github.thangdev99.newsapp.notification.NotificationManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class FetchTopHeadlinesWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val syncTopHeadlinesUseCase: SyncTopHeadlinesUseCase,
    private val notificationManager: NotificationManager
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            Timber.d("Background sync started")
            
            // Fetch top headlines
            val result = syncTopHeadlinesUseCase(country = "us", category = null)
            
            result.onSuccess { articles ->
                Timber.d("Successfully synced ${articles.size} articles")
                
                // Show notification if new articles were found
                if (articles.isNotEmpty()) {
                    notificationManager.showNewArticlesNotification(articles.size)
                }
            }
            
            result.onFailure { error ->
                Timber.e(error, "Failed to sync articles")
            }
            
            // Return success regardless to avoid retries unless it's a special case
            Result.success()
        } catch (e: Exception) {
            Timber.e(e, "Worker failed with exception")
            // Retry on failure
            Result.retry()
        }
    }
}
