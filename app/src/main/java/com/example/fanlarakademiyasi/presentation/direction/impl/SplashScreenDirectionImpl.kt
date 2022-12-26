package com.example.fanlarakademiyasi.presentation.direction.impl

import com.example.fanlarakademiyasi.presentation.direction.SplashScreenDirection
import com.example.fanlarakademiyasi.presentation.navigation.Navigator
import com.example.fanlarakademiyasi.presentation.ui.screen.fragment.splash.SplashScreenDirections
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : SplashScreenDirection {

    override suspend fun openMainScreen() {
        navigator.navigateTo(SplashScreenDirections.actionSplashScreenToMainScreen())
    }

    override suspend fun openIntroScreen() {
        navigator.navigateTo(SplashScreenDirections.actionSplashScreenToIntroScreen())
    }

    override suspend fun openChooseLanguageScreen() {
        navigator.navigateTo(SplashScreenDirections.actionSplashScreenToChooseLanguageScreen())
    }
}