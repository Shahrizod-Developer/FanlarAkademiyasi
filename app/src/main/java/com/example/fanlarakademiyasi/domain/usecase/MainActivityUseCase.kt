package com.example.fanlarakademiyasi.domain.usecase

import kotlinx.coroutines.flow.Flow

interface MainActivityUseCase {

    fun getLanguage(): Flow<String>
}