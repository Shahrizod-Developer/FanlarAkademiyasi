package com.example.fanlarakademiyasi.data.remote.firebase.response

import com.example.fanlarakademiyasi.data.local.room.entity.ArticleEntity

data class ArticleResponse(
    val id: String,
    val childCategoryCode: Int,
    val image: String,
    val title: String,
    val desc: String,
    val text: String,
    val date: String,
    val seenCount: Int,
    val storageUrl: String
){
    fun toEntity() = ArticleEntity(
        id, childCategoryCode, image, title, desc, text, date, seenCount, storageUrl
    )
}