package com.example.fanlarakademiyasi.domain.repository

import com.example.fanlarakademiyasi.data.model.Article
import com.example.fanlarakademiyasi.data.model.Category
import com.example.fanlarakademiyasi.data.model.ChildCategory
import com.example.fanlarakademiyasi.data.model.IntroData
import com.example.fanlarakademiyasi.data.utils.ResultData
import kotlinx.coroutines.flow.Flow

interface AppRepository {


    suspend fun setIsFirst(isFirst: Boolean)

    fun getIsFirst(): Flow<Boolean>

    fun getIntroData(): Flow<List<IntroData>>

    fun getIsFirstIntro(): Flow<Boolean>

    suspend fun setIsFirstIntro(state: Boolean)

    suspend fun setLanguage(lang: String)

    fun getLanguage(): Flow<String>

    fun getAllCategory(): Flow<List<Category>>

    fun getChildCategoryByQuery(query: Int): Flow<List<ChildCategory>>

    fun getArticleByQuery(query: Int): Flow<Article>

    fun categoryRefreshData(): Flow<ResultData<Boolean>>

    fun childCategoryRefreshData(): Flow<ResultData<Boolean>>

    fun articleRefreshData(): Flow<ResultData<Boolean>>
}