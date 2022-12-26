package com.example.fanlarakademiyasi.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fanlarakademiyasi.data.model.Article


@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo(name = "child_category_code")
    val childCategoryCode: Int,
    val image: String,
    val title: String,
    val desc: String,
    val text: String,
    val date: String,
    @ColumnInfo(name = "seen_count")
    val seenCount: Int,
    @ColumnInfo(name = "storage_url")
    val storageUrl: String,
    val isDownload: Boolean = false
) {
    fun toArticle() = Article(
        id, childCategoryCode, image, title, desc, text, date, seenCount, storageUrl, isDownload
    )
}