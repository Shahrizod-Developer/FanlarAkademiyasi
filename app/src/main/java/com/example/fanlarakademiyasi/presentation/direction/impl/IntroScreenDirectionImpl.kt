package com.example.fanlarakademiyasi.presentation.direction.impl

import com.example.fanlarakademiyasi.presentation.direction.IntroScreenDirection
import com.example.fanlarakademiyasi.presentation.navigation.Direction
import com.example.fanlarakademiyasi.presentation.navigation.Navigator
import com.example.fanlarakademiyasi.presentation.ui.screen.fragment.intro.IntroScreenDirections
import javax.inject.Inject

class IntroScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : IntroScreenDirection {
    override suspend fun openChooseLanguageScreen() {
        navigator.navigateTo(IntroScreenDirections.actionIntroScreenToChooseLanguageScreen())
    }
}