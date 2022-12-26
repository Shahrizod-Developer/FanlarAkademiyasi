package com.example.fanlarakademiyasi.domain.usecase.impl

import com.example.fanlarakademiyasi.domain.repository.AppRepository
import com.example.fanlarakademiyasi.domain.usecase.MainActivityUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainActivityUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : MainActivityUseCase {

    override fun getLanguage():Flow<String> = repository.getLanguage()

}