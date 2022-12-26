package com.example.fanlarakademiyasi.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.fanlarakademiyasi.data.local.room.entity.ChildCategoryEntity
import com.example.fanlarakademiyasi.data.model.ChildCategory
import kotlinx.coroutines.flow.Flow


@Dao
interface ChildCategoryDao : BaseDao<ChildCategoryEntity> {

    @Query("Select * From child_category Where category_code =:query")
    fun getByQueryChildCategory(query: Int): Flow<List<ChildCategoryEntity>>
}