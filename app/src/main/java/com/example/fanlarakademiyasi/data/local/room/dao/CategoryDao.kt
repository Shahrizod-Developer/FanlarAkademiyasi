package com.example.fanlarakademiyasi.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.fanlarakademiyasi.data.local.room.entity.CategoryEntity
import com.example.fanlarakademiyasi.data.model.Category
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDao : BaseDao<CategoryEntity> {

    @Query("Select * From category")
    fun getAllCategory(): Flow<List<CategoryEntity>>
}