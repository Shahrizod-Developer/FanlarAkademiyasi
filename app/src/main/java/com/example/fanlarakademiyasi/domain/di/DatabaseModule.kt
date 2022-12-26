package com.example.fanlarakademiyasi.domain.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.fanlarakademiyasi.data.local.room.dao.ArticleDao
import com.example.fanlarakademiyasi.data.local.room.dao.CategoryDao
import com.example.fanlarakademiyasi.data.local.room.dao.ChildCategoryDao
import com.example.fanlarakademiyasi.data.local.room.database.AppDatabase
import com.example.fanlarakademiyasi.data.local.shp.impl.MySharedPreference
import com.example.fanlarakademiyasi.data.remote.firebase.api.Api
import com.example.fanlarakademiyasi.data.remote.firebase.api.impl.ApiImpl
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "book_data"

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext ctx: Context): AppDatabase =
        Room.databaseBuilder(ctx, AppDatabase::class.java, DATABASE_NAME)
            .build()

    @[Provides Singleton]
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao = appDatabase.categoryDao()

    @[Provides Singleton]
    fun provideChildCategoryDao(appDatabase: AppDatabase): ChildCategoryDao =
        appDatabase.childCategoryDao()

    @[Provides Singleton]
    fun provideArticleDao(appDatabase: AppDatabase): ArticleDao = appDatabase.articleDao()

    @[Provides Singleton]
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("app_data", Context.MODE_PRIVATE)

    @[Provides Singleton]
    fun provideSharedPrefs(
        @ApplicationContext context: Context,
        sharedPreferences: SharedPreferences
    ): MySharedPreference =
        MySharedPreference(context, sharedPreferences)

    @[Provides Singleton]
    fun provideFireStore(): FirebaseFirestore = Firebase.firestore

    @[Provides Singleton]
    fun provideApi(fireStore: FirebaseFirestore, shp: MySharedPreference): Api =
        ApiImpl(fireStore, shp)
}