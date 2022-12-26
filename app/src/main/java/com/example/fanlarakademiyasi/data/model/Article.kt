package com.example.fanlarakademiyasi.data.model

import com.example.fanlarakademiyasi.data.local.room.entity.ArticleEntity

data class Article(
    val id: String,
    val childCategoryCode: Int,
    val image: String,
    val title: String,
    val desc: String,
    val text: String,
    val date: String,
    val seenCount: Int,
    val storageUrl: String,
    val isDownload: Boolean
) {
    fun toEntity() = ArticleEntity(
        id, childCategoryCode, image, title, desc, text, date, seenCount, storageUrl, isDownload
    )
}