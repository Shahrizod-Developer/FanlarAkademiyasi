package com.example.fanlarakademiyasi.domain.usecase

interface ChooseLanguageScreenUseCase {

    suspend fun setIsFirst(state: Boolean)

    suspend fun setLanguage(lang: String)
}