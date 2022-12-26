package com.example.fanlarakademiyasi.data.model

import com.example.fanlarakademiyasi.data.local.room.entity.CategoryEntity

data class Category(
    val id: String, val title: String, val code: Int
) {
    fun toEntity() = CategoryEntity(id, title, code)
}