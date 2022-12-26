package com.example.fanlarakademiyasi.data.remote.firebase.api.impl

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.fanlarakademiyasi.data.local.shp.impl.MySharedPreference
import com.example.fanlarakademiyasi.data.model.*
import com.example.fanlarakademiyasi.data.remote.firebase.api.Api
import com.example.fanlarakademiyasi.data.remote.firebase.request.Request
import com.example.fanlarakademiyasi.data.remote.firebase.response.ArticleResponse
import com.example.fanlarakademiyasi.data.remote.mapper.Mapper.toArticle
import com.example.fanlarakademiyasi.data.remote.mapper.Mapper.toCategoryData
import com.example.fanlarakademiyasi.data.remote.mapper.Mapper.toChildCategory
import com.example.fanlarakademiyasi.data.utils.NoInternetConnection
import com.example.fanlarakademiyasi.data.utils.ResultData
import com.example.fanlarakademiyasi.data.utils.hasConnection
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ApiImpl @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val shp: MySharedPreference
) : Api {


    @RequiresApi(Build.VERSION_CODES.M)
    override fun getAllCategories() = callbackFlow<ResultData<List<Category>>> {
        if (hasConnection()) {
            fireStore.collection("categories")
                .get()
                .addOnSuccessListener {
                    val list = it.documents.map { dataSnapshot ->
                        dataSnapshot.toCategoryData()
                    }
                    trySend(ResultData.Success(list))
                }.addOnFailureListener {
                    trySend(ResultData.Error(it))
                }.addOnCanceledListener {
                    trySend(ResultData.Message("Uploading the list of categories was canceled"))
                }
        } else {
            throw NoInternetConnection()
        }
        awaitClose {
        }
    }.catch { error ->
        emit(ResultData.Error(error))
    }.flowOn(Dispatchers.IO)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getAllChildCategory() =
        callbackFlow<ResultData<List<ChildCategory>>> {
            if (hasConnection()) {
                fireStore.collection("child_categories")
                    .get()
                    .addOnSuccessListener {
                        val list = it.documents.map { dataSnapshot ->
                            dataSnapshot.toChildCategory()
                        }
                        Log.d("TTT", list.size.toString())
                        trySend(ResultData.Success(list))
                    }.addOnFailureListener {
                        trySend(ResultData.Error(it))
                    }.addOnCanceledListener {
                        trySend(ResultData.Message("Uploading the list of child categories was canceled"))
                    }
            } else {
                throw NoInternetConnection()
            }
            awaitClose {
            }
        }.catch { error ->
            emit(ResultData.Error(error))
        }.flowOn(Dispatchers.IO)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getAllArticle() = callbackFlow<ResultData<List<ArticleResponse>>> {
        if (hasConnection()) {
            fireStore.collection("articles")
                .get()
                .addOnSuccessListener {
                    val list = it.documents.map { dataSnapshot ->
                        dataSnapshot.toArticle()
                    }
                    trySend(ResultData.Success(list))
                }.addOnFailureListener {
                    trySend(ResultData.Error(it))
                }.addOnCanceledListener {
                    trySend(ResultData.Message("Uploading the list of categories was canceled"))
                }
        } else {
            throw NoInternetConnection()
        }
        awaitClose {
        }
    }

    override fun getAllPhotos(): Flow<ResultData<List<Photo>>> = flow {

    }

    override fun getAllVideos(): Flow<ResultData<List<Video>>> = flow {

    }

    override fun getAllOpenData(): Flow<ResultData<List<OpenData>>> = flow {

    }
}