package com.example.fanlarakademiyasi.domain.usecase.impl

import com.example.fanlarakademiyasi.domain.repository.AppRepository
import com.example.fanlarakademiyasi.domain.usecase.ChooseLanguageScreenUseCase
import javax.inject.Inject

class ChooseLanguageScreenUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : ChooseLanguageScreenUseCase {

    override suspend fun setIsFirst(state: Boolean) = repository.setIsFirst(state)

    override suspend fun setLanguage(lang: String) = repository.setLanguage(lang)
}