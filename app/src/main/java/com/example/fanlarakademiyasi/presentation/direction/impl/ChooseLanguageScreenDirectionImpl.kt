package com.example.fanlarakademiyasi.presentation.direction.impl

import com.example.fanlarakademiyasi.presentation.direction.ChooseLanguageScreenDirection
import com.example.fanlarakademiyasi.presentation.navigation.Navigator
import com.example.fanlarakademiyasi.presentation.ui.screen.fragment.intro.ChooseLanguageScreenDirections
import javax.inject.Inject

class ChooseLanguageScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : ChooseLanguageScreenDirection {

    override suspend fun openMainScreen() {
        navigator.navigateTo(ChooseLanguageScreenDirections.actionChooseLanguageScreenToMainScreen())
    }

}