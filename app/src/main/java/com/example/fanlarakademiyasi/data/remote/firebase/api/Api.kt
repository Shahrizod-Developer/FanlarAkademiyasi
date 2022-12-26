package com.example.fanlarakademiyasi.data.remote.firebase.api

import com.example.fanlarakademiyasi.data.model.*
import com.example.fanlarakademiyasi.data.remote.firebase.request.Request
import com.example.fanlarakademiyasi.data.remote.firebase.response.ArticleResponse
import com.example.fanlarakademiyasi.data.utils.ResultData
import kotlinx.coroutines.flow.Flow

interface Api {

    fun getAllCategories(): Flow<ResultData<List<Category>>>

    fun getAllChildCategory(): Flow<ResultData<List<ChildCategory>>>

    fun getAllArticle(): Flow<ResultData<List<ArticleResponse>>>

    fun getAllPhotos(): Flow<ResultData<List<Photo>>>

    fun getAllVideos(): Flow<ResultData<List<Video>>>

    fun getAllOpenData(): Flow<ResultData<List<OpenData>>>
}