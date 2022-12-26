package com.example.fanlarakademiyasi.domain.usecase.impl

import com.example.fanlarakademiyasi.data.model.Category
import com.example.fanlarakademiyasi.data.utils.ResultData
import com.example.fanlarakademiyasi.domain.repository.AppRepository
import com.example.fanlarakademiyasi.domain.usecase.HomeScreenUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeScreenUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : HomeScreenUseCase {
    override fun getAllCategory(): Flow<List<Category>> = repository.getAllCategory()

    override fun refreshCategoryData(): Flow<ResultData<Boolean>> = repository.categoryRefreshData()
}