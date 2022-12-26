package com.example.fanlarakademiyasi.domain.usecase

import com.example.fanlarakademiyasi.data.model.Category
import com.example.fanlarakademiyasi.data.utils.ResultData
import kotlinx.coroutines.flow.Flow

interface HomeScreenUseCase {

    fun getAllCategory(): Flow<List<Category>>

    fun refreshCategoryData(): Flow<ResultData<Boolean>>
}