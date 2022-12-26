package com.example.fanlarakademiyasi.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fanlarakademiyasi.data.local.room.dao.ArticleDao
import com.example.fanlarakademiyasi.data.local.room.dao.CategoryDao
import com.example.fanlarakademiyasi.data.local.room.dao.ChildCategoryDao
import com.example.fanlarakademiyasi.data.local.room.entity.ArticleEntity
import com.example.fanlarakademiyasi.data.local.room.entity.CategoryEntity
import com.example.fanlarakademiyasi.data.local.room.entity.ChildCategoryEntity


@Database(
    entities = [ArticleEntity::class, CategoryEntity::class, ChildCategoryEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun childCategoryDao(): ChildCategoryDao
    abstract fun articleDao(): ArticleDao
}