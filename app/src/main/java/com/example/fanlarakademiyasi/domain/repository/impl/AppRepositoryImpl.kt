package com.example.fanlarakademiyasi.domain.repository.impl

import android.util.Log
import com.example.fanlarakademiyasi.data.local.room.dao.ArticleDao
import com.example.fanlarakademiyasi.data.local.room.dao.CategoryDao
import com.example.fanlarakademiyasi.data.local.room.dao.ChildCategoryDao
import com.example.fanlarakademiyasi.data.local.shp.impl.MySharedPreference
import com.example.fanlarakademiyasi.data.model.Article
import com.example.fanlarakademiyasi.data.model.Category
import com.example.fanlarakademiyasi.data.model.ChildCategory
import com.example.fanlarakademiyasi.data.model.Data.introData
import com.example.fanlarakademiyasi.data.model.IntroData
import com.example.fanlarakademiyasi.data.remote.firebase.api.Api
import com.example.fanlarakademiyasi.data.utils.ResultData
import com.example.fanlarakademiyasi.domain.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val sharedPreference: MySharedPreference,
    private val api: Api,
    private val categoryDao: CategoryDao,
    private val childCategoryDao: ChildCategoryDao,
    private val articleDao: ArticleDao
) : AppRepository {

    override suspend fun setIsFirst(isFirst: Boolean) {
        coroutineScope {
            sharedPreference.isFirst = isFirst
        }
    }

    override fun getIsFirst(): Flow<Boolean> = flow {
        emit(sharedPreference.isFirst)
    }

    override fun getIntroData(): Flow<List<IntroData>> = flow { emit(introData) }

    override fun getIsFirstIntro(): Flow<Boolean> = flow { emit(sharedPreference.isFirstIntro) }

    override suspend fun setIsFirstIntro(state: Boolean) {
        coroutineScope { sharedPreference.isFirstIntro = state }
    }

//    override fun refreshCategoryData(): Flow<ResultData<Boolean>> = channelFlow {
//        api.getAllCategories().collectLatest { result ->
//            result.onSuccess { books ->
//                send(ResultData.Success(true))
//            }.onMessage {
//                send(ResultData.Message(it))
//            }.onError { send(ResultData.Error(it)) }
//
//        }
//    }

    override suspend fun setLanguage(lang: String) {
        coroutineScope {
            sharedPreference.language = lang
        }
    }

    override fun getLanguage(): Flow<String> = flow { emit(sharedPreference.language) }

    override fun getAllCategory(): Flow<List<Category>> = flow {
        categoryDao.getAllCategory().map {
            emit(it.map { it.toCategory() })
        }.collect()
    }

    override fun getChildCategoryByQuery(query: Int): Flow<List<ChildCategory>> = flow {
        childCategoryDao.getByQueryChildCategory(query).map {
            emit(it.map { it.toChildCategory() })
        }.collect()
    }

    override fun getArticleByQuery(query: Int): Flow<Article> = flow {
        articleDao.getArticleByQuery(query).collectLatest {
            emit(it.toArticle())
        }
    }

    override fun categoryRefreshData(): Flow<ResultData<Boolean>> =
        channelFlow<ResultData<Boolean>> {
            api.getAllCategories().collectLatest {
                it.onSuccess {
                    Log.d("TTT", it.toString() + "from api")
                    categoryDao.insert(it.map {
                        it.toEntity()
                    })
                    send(ResultData.Success(true))
                }.onMessage {
                    send(ResultData.Message(it))
                }.onError {
                    send(ResultData.Error(it))
                }
            }
        }

    override fun childCategoryRefreshData(): Flow<ResultData<Boolean>> =
        channelFlow<ResultData<Boolean>> {
            api.getAllChildCategory().collectLatest {
                it.onSuccess {
                    childCategoryDao.insert(it.map {
                        it.toEntity()
                    })
                }.onMessage {
                    send(ResultData.Message(it))
                }.onError { send(ResultData.Error(it)) }
            }
        }.flowOn(Dispatchers.IO)

    override fun articleRefreshData(): Flow<ResultData<Boolean>> = channelFlow {
        api.getAllArticle().collectLatest {
            it.onSuccess {
                articleDao.insert(it.map {
                    it.toEntity()
                })
            }.onMessage {
                send(ResultData.Message(it))
            }.onError { send(ResultData.Error(it)) }
        }
    }
}