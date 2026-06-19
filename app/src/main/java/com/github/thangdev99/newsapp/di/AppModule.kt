package com.github.thangdev99.newsapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.github.thangdev99.domain.repository.PreferenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.github.thangdev99.data.repository.PreferenceRepositoryImpl
import com.github.thangdev99.data.utils.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatastorePreferences(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(Constants.NEWS_APP_PREFERENCES)
            }
        )

    @Provides
    @Singleton
    fun providePreferenceRepository(dataStore: DataStore<Preferences>): PreferenceRepository =
        PreferenceRepositoryImpl(dataStore)
}
