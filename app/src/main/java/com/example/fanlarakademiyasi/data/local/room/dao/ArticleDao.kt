package com.example.fanlarakademiyasi.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.fanlarakademiyasi.data.local.room.entity.ArticleEntity
import com.example.fanlarakademiyasi.data.model.Article
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticleDao : BaseDao<ArticleEntity> {

    @Query("Select * From articles Where child_category_code = :query")
    fun getArticleByQuery(query: Int): Flow<ArticleEntity>
}