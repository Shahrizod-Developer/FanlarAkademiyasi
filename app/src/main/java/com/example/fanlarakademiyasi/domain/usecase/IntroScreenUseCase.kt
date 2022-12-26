package com.example.fanlarakademiyasi.domain.usecase

import com.example.fanlarakademiyasi.data.model.IntroData
import kotlinx.coroutines.flow.Flow

interface IntroScreenUseCase {

    fun getIntroData(): Flow<List<IntroData>>

    suspend fun setIsFirstIntro(state: Boolean)
}