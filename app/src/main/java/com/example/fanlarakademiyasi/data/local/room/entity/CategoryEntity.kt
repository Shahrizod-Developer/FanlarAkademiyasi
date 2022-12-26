package com.example.fanlarakademiyasi.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fanlarakademiyasi.data.model.Category


@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val code: Int
) {
    fun toCategory() = Category(id, title, code)
}