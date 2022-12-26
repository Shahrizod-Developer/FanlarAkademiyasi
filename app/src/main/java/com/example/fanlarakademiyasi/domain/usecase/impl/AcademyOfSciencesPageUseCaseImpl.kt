package com.example.fanlarakademiyasi.domain.usecase.impl

import com.example.fanlarakademiyasi.data.utils.ResultData
import com.example.fanlarakademiyasi.domain.repository.AppRepository
import com.example.fanlarakademiyasi.domain.usecase.AcademyOfSciencesPageUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AcademyOfSciencesPageUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : AcademyOfSciencesPageUseCase {
    override fun getChildCategoryByQuery(query: Int) = repository.getChildCategoryByQuery(query)

    override fun childCategoryRefreshData(): Flow<ResultData<Boolean>> =
        repository.childCategoryRefreshData()
}