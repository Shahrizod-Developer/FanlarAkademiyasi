package com.example.fanlarakademiyasi.data.model

import com.example.fanlarakademiyasi.data.local.room.entity.ChildCategoryEntity

data class ChildCategory(
    val id: String,
    val title: String,
    val code: Int,
    val categoryCode: Int
) {
    fun toEntity() = ChildCategoryEntity(
        id, title, code, categoryCode
    )
}