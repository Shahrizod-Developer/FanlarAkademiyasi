package com.example.fanlarakademiyasi.domain.usecase.impl

import com.example.fanlarakademiyasi.domain.repository.AppRepository
import com.example.fanlarakademiyasi.domain.usecase.SplashScreenUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SplashScreenUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : SplashScreenUseCase {
    override fun getIsFirst(): Flow<Boolean> = repository.getIsFirst()

    override fun getIsFirstIntro(): Flow<Boolean> = repository.getIsFirstIntro()
}