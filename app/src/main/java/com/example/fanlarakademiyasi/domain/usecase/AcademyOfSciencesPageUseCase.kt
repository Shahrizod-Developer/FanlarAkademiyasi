package com.example.fanlarakademiyasi.domain.usecase

import com.example.fanlarakademiyasi.data.model.ChildCategory
import com.example.fanlarakademiyasi.data.utils.ResultData
import kotlinx.coroutines.flow.Flow

interface AcademyOfSciencesPageUseCase {

    fun getChildCategoryByQuery(query: Int): Flow<List<ChildCategory>>

    fun childCategoryRefreshData(): Flow<ResultData<Boolean>>
}