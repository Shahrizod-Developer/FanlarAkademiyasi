package com.example.fanlarakademiyasi.domain.usecase.impl

import com.example.fanlarakademiyasi.data.model.IntroData
import com.example.fanlarakademiyasi.domain.repository.AppRepository
import com.example.fanlarakademiyasi.domain.usecase.IntroScreenUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IntroScreenUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : IntroScreenUseCase {
    override suspend fun setIsFirstIntro(isFirst: Boolean) = repository.setIsFirstIntro(isFirst)

    override fun getIntroData(): Flow<List<IntroData>> = repository.getIntroData()
}