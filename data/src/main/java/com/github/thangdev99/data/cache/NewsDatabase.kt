package com.github.thangdev99.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NewsEntity::class],
    version = 2,
    exportSchema = true
)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}
