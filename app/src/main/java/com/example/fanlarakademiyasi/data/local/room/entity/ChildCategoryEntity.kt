package com.example.fanlarakademiyasi.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fanlarakademiyasi.data.model.ChildCategory


@Entity(tableName = "child_category")
data class ChildCategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val code: Int,
    @ColumnInfo(name = "category_code")
    val categoryCode: Int
) {
    fun toChildCategory() = ChildCategory(
        id, title, code, categoryCode
    )
}