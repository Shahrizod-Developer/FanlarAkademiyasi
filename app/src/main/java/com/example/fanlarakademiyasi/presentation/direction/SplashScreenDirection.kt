package com.example.fanlarakademiyasi.presentation.direction

interface SplashScreenDirection {

    suspend fun openMainScreen()

    suspend fun openIntroScreen()

    suspend fun openChooseLanguageScreen()
}