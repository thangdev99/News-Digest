package com.github.thangdev99.newsapp.di

import com.github.thangdev99.domain.repository.FavoriteRepository
import com.github.thangdev99.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.github.thangdev99.data.repository.FavoriteRepositoryImpl
import com.github.thangdev99.data.repository.NewsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(repository: NewsRepositoryImpl): NewsRepository

    @Binds
    abstract fun bindFavoriteRepository(repository: FavoriteRepositoryImpl): FavoriteRepository
}
